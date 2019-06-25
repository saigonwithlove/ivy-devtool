package saigonwithlove.ivy.devtool.configuration;

import ch.ivyteam.ivy.application.IApplication;
import com.google.common.base.Preconditions;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public class GlobalVariables {
  public static void setValue(IApplication application, String name, String value) {
    Preconditions.checkNotNull(application);
    Preconditions.checkArgument(StringUtils.isNotEmpty(name));
    Preconditions.checkNotNull(value);
    Optional.ofNullable(application.findGlobalVariable(name))
        .orElseThrow(() -> new IllegalArgumentException("Global variable not found: " + name))
        .setValue(value);
  }
}
