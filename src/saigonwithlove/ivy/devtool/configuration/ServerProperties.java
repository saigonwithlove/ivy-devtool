package saigonwithlove.ivy.devtool.configuration;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.server.IServer;
import ch.ivyteam.ivy.system.ISystemProperty;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class ServerProperties {

  public static void setValue(IServer server, String name, String value) {
    Preconditions.checkNotNull(server);
    Preconditions.checkArgument(StringUtils.isNotEmpty(name));
    Preconditions.checkNotNull(value);
    Ivy.log().info("[ivy-devtool] Set system property: name: {0}, value: {1}", name, value);
    Optional.ofNullable(server.getApplicationConfigurationManager().getSystemProp(name))
        .ifPresent(property -> property.setValue(value));
  }

  public static Map<String, String> findAll(IServer server) {
    return server.getApplicationConfigurationManager().getSystemProps().stream()
        .collect(Collectors.toMap(ISystemProperty::getName, ISystemProperty::getValue));
  }
}
