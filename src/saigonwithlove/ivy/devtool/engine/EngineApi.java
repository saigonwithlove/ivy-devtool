package saigonwithlove.ivy.devtool.engine;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.request.IHttpRequest;
import ch.ivyteam.ivy.request.IHttpResponse;
import ch.ivyteam.ivy.request.IRequest;
import ch.ivyteam.ivy.request.IResponse;
import ch.ivyteam.ivy.server.ServerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.entity.ContentType;
import saigonwithlove.ivy.devtool.configuration.GlobalVariables;
import saigonwithlove.ivy.devtool.configuration.ServerProperties;

public class EngineApi {
  private static final String PARAM_COMMAND = "command";
  private static final String COMMAND_SEPARATOR = "\\$";

  public static EngineApi newInstance() {
    return new EngineApi();
  }

  public void handleRequest(IApplication application, IRequest request, IResponse response)
      throws IOException {
    String[] command = getParameter(request, PARAM_COMMAND).split(COMMAND_SEPARATOR);
    if ("module".equalsIgnoreCase(command[0])) {
      if ("reload".equalsIgnoreCase(command[1])) {
        String pm = getParameter(request, "pm");
        String pmv = getParameter(request, "pmv");
        ProcessModelVersions.reload(application, pm, pmv);
      }
    } else if ("global-variable".equalsIgnoreCase(command[0])) {
      if ("set".equalsIgnoreCase(command[1])) {
        String name = getParameter(request, "name");
        String value = getParameter(request, "value");
        GlobalVariables.setValue(application, name, value);
      }
    } else if ("server-property".equalsIgnoreCase(command[0])) {
      if ("get-all".equalsIgnoreCase(command[1])) {
        Map<String, String> systemProperties = ServerProperties.findAll(ServerFactory.getServer());
        HttpServletResponse httpServletResponse =
            ((IHttpResponse) response).getHttpServletResponse();
        httpServletResponse.setContentType(ContentType.APPLICATION_JSON.getMimeType());
        new ObjectMapper().writeValue(httpServletResponse.getOutputStream(), systemProperties);
      } else if ("set".equalsIgnoreCase(command[1])) {
        String name = getParameter(request, "name");
        String value = getParameter(request, "value");
        ServerProperties.setValue(ServerFactory.getServer(), name, value);
      }
    }
  }

  private String getParameter(IRequest request, String name) {
    return ((IHttpRequest) request).getHttpServletRequest().getParameter(name);
  }
}
