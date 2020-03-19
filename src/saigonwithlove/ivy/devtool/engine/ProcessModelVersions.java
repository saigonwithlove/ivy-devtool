package saigonwithlove.ivy.devtool.engine;

import ch.ivyteam.ivy.application.ActivityOperationState;
import ch.ivyteam.ivy.application.ILibrary;
import ch.ivyteam.ivy.application.IProcessModelVersion;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.java.JavaConfigurationNavigationUtil;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class ProcessModelVersions {

  public static void reload(String processModel, String processModelVersion) {
    Preconditions.checkArgument(StringUtils.isNotBlank(processModel));
    Preconditions.checkArgument(StringUtils.isNotBlank(processModelVersion));
    IProcessModelVersion pmv =
        Ivy.wf().getApplication().findProcessModelVersion(processModel + "$" + processModelVersion);
    reload(pmv);
  }

  private static void reload(IProcessModelVersion pmv) {
    deactivate(pmv);
    JavaConfigurationNavigationUtil.getJavaConfiguration(pmv)
        .getClassLoaderHolder()
        .updateRepositories();
    activate(pmv);
    pmv.getLibrary().getAllDependentLibraries().stream()
        .map(ILibrary::getProcessModelVersion)
        .forEach(ProcessModelVersions::reload);
  }

  private static void activate(IProcessModelVersion pmv) {
    pmv.activate();
    int timeOut = 10;
    while (pmv.getActivityOperationState() != ActivityOperationState.ACTIVE) {
      if (timeOut < 0) {
        throw new RuntimeException("Process Model Version takes to long to activate.");
      }
      sleep();
      timeOut -= 1;
    }
  }

  private static void sleep() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException ex) {
      Ivy.log().error(ex);
    }
  }

  private static void deactivate(IProcessModelVersion pmv) {
    pmv.deactivate();
    int timeOut = 10;
    while (pmv.getActivityOperationState() != ActivityOperationState.INACTIVE) {
      if (timeOut < 0) {
        throw new RuntimeException("Process Model Version takes to long to deactivate.");
      }
      sleep();
      timeOut -= 1;
    }
  }
}
