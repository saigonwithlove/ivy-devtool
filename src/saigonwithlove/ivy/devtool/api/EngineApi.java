package saigonwithlove.ivy.devtool.api;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.request.IHttpRequest;
import ch.ivyteam.ivy.request.IHttpResponse;
import ch.ivyteam.ivy.request.IRequest;
import ch.ivyteam.ivy.request.IResponse;
import ch.ivyteam.ivy.server.ServerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import saigonwithlove.ivy.devtool.configuration.GlobalVariables;
import saigonwithlove.ivy.devtool.configuration.ServerProperties;
import saigonwithlove.ivy.devtool.engine.ProcessModelVersions;

public class EngineApi {
  private static final String PARAM_COMMAND = "command";
  private static final String PARAM_PROCESS_MODEL = "pm";
  private static final String PARAM_PROCESS_MODEL_VERSION = "pmv";
  private static final String COMMAND_SEPARATOR = "\\$";

  public static EngineApi newInstance() {
    return new EngineApi();
  }

  public void handleRequest(IApplication application, IRequest request, IResponse response)
      throws IOException {
    String[] command = getParameter(request, PARAM_COMMAND).split(COMMAND_SEPARATOR);
    if ("module".equalsIgnoreCase(command[0])) {
      if ("reload".equalsIgnoreCase(command[1])) {
        String pm = getParameter(request, PARAM_PROCESS_MODEL);
        String pmv = getParameter(request, PARAM_PROCESS_MODEL_VERSION);
        ProcessModelVersions.reload(application, pm, pmv);
      } else if ("status".equalsIgnoreCase(command[1])) {
        String pm = getParameter(request, PARAM_PROCESS_MODEL);
        String pmv = getParameter(request, PARAM_PROCESS_MODEL_VERSION);
        String status = ProcessModelVersions.status(application, pm, pmv);
        ModuleProcessModelVersionStatusResponse responseContent =
            ModuleProcessModelVersionStatusResponse.builder()
                .processModel(pm)
                .processModelVersion(pmv)
                .status(status)
                .build();
        writeResponseContent(response, responseContent);
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
        writeResponseContent(response, systemProperties);
      } else if ("set".equalsIgnoreCase(command[1])) {
        String name = getParameter(request, "name");
        String value = getParameter(request, "value");
        ServerProperties.setValue(ServerFactory.getServer(), name, value);
      }
    }
  }

  private static String getParameter(IRequest request, String name) {
    return ((IHttpRequest) request).getHttpServletRequest().getParameter(name);
  }

  private static HttpServletResponse toHttpServletResponse(IResponse response) {
    return ((IHttpResponse) response).getHttpServletResponse();
  }

  private static void writeResponseContent(IResponse response, Object content) throws IOException {
    Objects.requireNonNull(response);
    Objects.requireNonNull(content);
    HttpServletResponse httpServletResponse = toHttpServletResponse(response);
    new ObjectMapper().writeValue(httpServletResponse.getOutputStream(), content);
  }
}
