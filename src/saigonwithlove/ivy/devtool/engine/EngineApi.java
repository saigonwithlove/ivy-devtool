package saigonwithlove.ivy.devtool.engine;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.request.IHttpRequest;
import ch.ivyteam.ivy.request.IRequest;
import saigonwithlove.ivy.devtool.configuration.GlobalVariables;

public class EngineApi {
  private static final String PARAM_COMMAND = "command";
  private static final String COMMAND_SEPARATOR = "\\$";

  public static EngineApi newInstance() {
    return new EngineApi();
  }

  public void handleRequest(IApplication application, IRequest request) {
    String[] command = getParameter(request, PARAM_COMMAND).split(COMMAND_SEPARATOR);
    if ("module".equalsIgnoreCase(command[0])) {
      if ("reload".equalsIgnoreCase(command[1])) {
        String pm = getParameter(request, "pm");
        String pmv = getParameter(request, "pmv");
        ProcessModelVersions.reload(pm, pmv);
      }
    }

    if ("global-variable".equalsIgnoreCase(command[0])) {
      if ("set".equalsIgnoreCase(command[1])) {
        String name = getParameter(request, "name");
        String value = getParameter(request, "value");
        GlobalVariables.setValue(application, name, value);
      }
    }
  }

  private String getParameter(IRequest request, String name) {
    return ((IHttpRequest) request).getHttpServletRequest().getParameter(name);
  }
}
