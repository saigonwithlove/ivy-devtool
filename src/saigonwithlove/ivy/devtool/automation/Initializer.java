package saigonwithlove.ivy.devtool.automation;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;

import org.apache.commons.io.FileUtils;

import saigonwithlove.ivy.devtool.configuration.GlobalVariables;
import saigonwithlove.ivy.devtool.configuration.ServerProperties;
import saigonwithlove.ivy.devtool.security.Roles;
import saigonwithlove.ivy.devtool.security.Users;
import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.scripting.objects.File;
import ch.ivyteam.ivy.security.IUser;
import ch.ivyteam.ivy.server.IServer;
import ch.ivyteam.ivy.server.ServerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Initializer {
  public static void initialize() {
    // SET DEFAULT LOCALE TO PREVENT ASPOSE NOT SUPPORTED CULTURE ERROR
    Locale.setDefault(Locale.US);

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
      URL initializationYaml = Initializer.class.getResource("/resources/initialization.yml");
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
      Optional.ofNullable(model.getGlobalVariables())
          .ifPresent(
              globalVariables ->
                  globalVariables.forEach(
                      var -> GlobalVariables.setValue(application, var.getName(), var.getValue())));
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
}
