package saigonwithlove.ivy.devtool.configuration;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.server.IServer;
import com.google.common.base.Preconditions;
import java.util.Optional;
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
}
