package saigonwithlove.ivy.devtool.configuration;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.environment.Ivy;
import com.google.common.base.Preconditions;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public class GlobalVariables {

  public static void setValue(IApplication application, String name, String value) {
    Preconditions.checkNotNull(application);
    Preconditions.checkArgument(StringUtils.isNotEmpty(name));
    Preconditions.checkNotNull(value);
    Ivy.log().info("[ivy-devtool] Set global variable: name: {0}, value: {1}", name, value);
    Optional.ofNullable(application.findGlobalVariable(name))
        .ifPresent(globalVariable -> globalVariable.setValue(value));
  }
}
