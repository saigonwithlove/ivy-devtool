package saigonwithlove.ivy.devtool.engine;

import ch.ivyteam.ivy.request.IHttpRequest;
import ch.ivyteam.ivy.request.IRequest;

public class EngineApi {
  public static EngineApi newInstance() {
    return new EngineApi();
  }

  public void handleRequest(IRequest request) {
    String command = getParameter(request, "command");
    if ("module$reload".equalsIgnoreCase(command)) {
      String pm = getParameter(request, "pm");
      String pmv = getParameter(request, "pmv");
      ProcessModelVersions.reload(pm + "$" + pmv);
    }
  }

  private String getParameter(IRequest request, String name) {
    return ((IHttpRequest) request).getHttpServletRequest().getParameter(name);
  }
}
