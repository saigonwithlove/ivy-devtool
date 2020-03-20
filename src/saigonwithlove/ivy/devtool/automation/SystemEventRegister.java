package saigonwithlove.ivy.devtool.automation;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.eventstart.AbstractProcessStartEventBean;
import ch.ivyteam.ivy.process.eventstart.IProcessStartEventBeanRuntime;
import ch.ivyteam.ivy.service.ServiceException;
import org.eclipse.core.runtime.IProgressMonitor;

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
    Ivy.log().info("[ivy-devtool] Start initializing Ivy Devtool.");
    Initializer.initialize();
  }

  @Override
  public void stop(IProgressMonitor monitor) throws ServiceException {
    super.stop(monitor);
  }
}
