package saigonwithlove.ivy.devtool.automation;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.eventstart.AbstractProcessStartEventBean;
import ch.ivyteam.ivy.process.eventstart.IProcessStartEventBeanRuntime;
import ch.ivyteam.ivy.scripting.objects.File;
import ch.ivyteam.ivy.security.IUser;
import ch.ivyteam.ivy.server.IServer;
import ch.ivyteam.ivy.server.ServerFactory;
import ch.ivyteam.ivy.service.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import saigonwithlove.ivy.devtool.configuration.GlobalVariables;
import saigonwithlove.ivy.devtool.configuration.ServerProperties;
import saigonwithlove.ivy.devtool.security.Roles;
import saigonwithlove.ivy.devtool.security.Users;

public class SystemEventRegister extends AbstractProcessStartEventBean {

  public SystemEventRegister() {
    super(SystemEventRegister.class.getCanonicalName(), "Manage System Event Listeners");
  }

  @Override
  public void initialize(IProcessStartEventBeanRuntime eventRuntime, String configuration) {
    super.initialize(eventRuntime, configuration);
  }

  @Override
  public void start(IProgressMonitor monitor) throws ServiceException {
    super.start(monitor);
    Ivy.log().warn("[ivy-devtool] SystemEventRegister started.");

    // CLEAN UP FILES
    try {
      FileUtils.cleanDirectory(new File(".", false).getJavaFile());
      Ivy.log().warn("[ivy-devtool] Cleaned application folder.");
    } catch (IOException ex) {
      Ivy.log().error("[ivy-devtool] Could not clean files.", ex);
    }

    IApplication application = Ivy.request().getApplication();
    try {
      // INIT DEVELOPER USER
      ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
      URL initializationYaml =
          SystemEventRegister.class.getResource("/resources/initialization.yml");
      InitializationModel model =
          objectMapper.readValue(initializationYaml, InitializationModel.class);
      model
          .getUsers()
          .forEach(
              user -> {
                IUser ivyUser =
                    Users.findUser(application, user.getUserName())
                        .orElseGet(
                            () ->
                                Users.newUser(application, user.getUserName(), user.getPassword()));
                Users.addRoles(ivyUser, Roles.findRoles(application));
              });
      Ivy.log().warn("[ivy-devtool] Finished setting up Developer user.");
      // END - INIT DEVELOPER USER

      // SET CUSTOM VALUE FOR GLOBAL VARIABLES
      model
          .getGlobalVariables()
          .forEach(var -> GlobalVariables.setValue(application, var.getName(), var.getValue()));
      Ivy.log().warn("[ivy-devtool] Finished setting up Global Variables.");
      // END - SET CUSTOM VALUE FOR GLOBAL VARIABLES

      // SET SYSTEM PROPERTY
      IServer server = ServerFactory.getServer();
      model
          .getServerProperties()
          .forEach(prop -> ServerProperties.setValue(server, prop.getName(), prop.getValue()));
      Ivy.log().warn("[ivy-devtool] Finished setting up System Properties.");
      // END - SET SYSTEM PROPERTY
    } catch (IOException ex) {
      Ivy.log().error(ex);
    }
  }

  @Override
  public void stop(IProgressMonitor monitor) throws ServiceException {
    Ivy.log().warn("SystemEventRegister stoped.");
    super.stop(monitor);
  }
}
