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
import java.net.URL;
import java.util.Optional;
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
    Initializer.initialize();
  }

  @Override
  public void stop(IProgressMonitor monitor) throws ServiceException {
    Ivy.log().warn("SystemEventRegister stoped.");
    super.stop(monitor);
  }
}
