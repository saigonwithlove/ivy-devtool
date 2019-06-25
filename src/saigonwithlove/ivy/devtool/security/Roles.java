package saigonwithlove.ivy.devtool.security;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.security.IRole;
import com.google.common.base.Preconditions;
import java.util.List;

public class Roles {
  public static List<IRole> findRoles(IApplication application) {
    Preconditions.checkNotNull(application);
    return application.getSecurityContext().getRoles();
  }
}
