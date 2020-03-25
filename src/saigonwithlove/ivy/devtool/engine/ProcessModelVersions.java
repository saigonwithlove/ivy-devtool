package saigonwithlove.ivy.devtool.engine;

import ch.ivyteam.ivy.application.ActivityOperationState;
import ch.ivyteam.ivy.application.ILibrary;
import ch.ivyteam.ivy.application.IProcessModel;
import ch.ivyteam.ivy.application.IProcessModelVersion;
import ch.ivyteam.ivy.deployment.restricted.DeploymentManagerFactory;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.java.JavaConfigurationNavigationUtil;
import ch.ivyteam.util.concurrent.Poll;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.plexus.util.DirectoryScanner;
import org.eclipse.core.runtime.NullProgressMonitor;

public class ProcessModelVersions {

  public static void reload(String processModel, String processModelVersion) {
    Preconditions.checkArgument(StringUtils.isNotBlank(processModel));
    Preconditions.checkArgument(StringUtils.isNotBlank(processModelVersion));
    IProcessModelVersion pmv =
        Ivy.wf().getApplication().findProcessModelVersion(processModel + "$" + processModelVersion);
    Ivy.log().info("[ivy-devtool] Reload module: {0}", pmv.getName());
    reload(pmv);
  }

  private static void reload(IProcessModelVersion pmv) {
    try {
      deactivate(pmv);
      DeploymentManagerFactory.createServerToServerDeploymentManager()
          .createProjectDeployer(pmv)
          .deploy(
              "System", "localhost", new NullProgressMonitor(), new DeploymentLogger(Ivy.log()));
      activate(pmv);
      updateDependents(pmv);
    } catch (Exception ex) {
      Ivy.log().error(ex);
    } finally {
      removeBackup(pmv.getProcessModel());
    }
  }

  private static void updateDependents(IProcessModelVersion pmv) {
    pmv.getLibrary().getAllDependentLibraries().stream()
        .map(ILibrary::getProcessModelVersion)
        .forEach(
            item -> {
              deactivate(item);
              JavaConfigurationNavigationUtil.getJavaConfiguration(item)
                  .getClassLoaderHolder()
                  .updateRepositories();
              activate(item);
              updateDependents(item);
            });
  }

  private static void removeBackup(IProcessModel pm) {
    DirectoryScanner scanner = new DirectoryScanner();
    scanner.setBasedir(pm.getFileDirectory());
    scanner.setIncludes(new String[] {"*Backup*.zip"});
    scanner.scan();
    for (String backup : scanner.getIncludedFiles()) {
      try {
        FileUtils.forceDelete(new File(scanner.getBasedir() + "/" + backup));
        Ivy.log().info("Backup removed: {0}", backup);
      } catch (IOException ex) {
        Ivy.log().error("Could not remove backup after deployment.", ex);
      }
    }
  }

  private static void activate(IProcessModelVersion pmv) {
    try {
      pmv.activate();
      Poll.await()
          .withDelay(2, TimeUnit.SECONDS)
          .untilOrTimeout(() -> pmv.getActivityOperationState() == ActivityOperationState.ACTIVE);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  private static void deactivate(IProcessModelVersion pmv) {
    try {
      pmv.deactivate();
      Poll.await()
          .withDelay(2, TimeUnit.SECONDS)
          .untilOrTimeout(() -> pmv.getActivityOperationState() == ActivityOperationState.INACTIVE);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
