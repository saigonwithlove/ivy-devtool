package saigonwithlove.ivy.devtool.security;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.security.IRole;
import ch.ivyteam.ivy.security.IUser;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public class Users {
  public static IUser newUser(IApplication application, String userName, String password) {
    Preconditions.checkNotNull(application);
    Preconditions.checkArgument(StringUtils.isNotBlank(userName));
    Preconditions.checkArgument(StringUtils.isNotBlank(password));
    Preconditions.checkArgument(
        notExists(application, password), "User already existed: " + userName);
    return application
        .getSecurityContext()
        .createUser(
            userName, // username
            "", // display name
            password,
            Locale.ENGLISH, // user language
            "", // email
            "");
  }

  public static Optional<IUser> findUser(IApplication application, String userName) {
    return Optional.ofNullable(application.getSecurityContext().findUser(userName));
  }

  public static boolean exists(IApplication application, String userName) {
    Preconditions.checkNotNull(application);
    Preconditions.checkArgument(StringUtils.isNotBlank(userName));
    return application.getSecurityContext().findUser(userName) != null;
  }

  public static boolean notExists(IApplication application, String userName) {
    return !exists(application, userName);
  }

  public static void addRoles(IUser user, List<IRole> roles) {
    Preconditions.checkNotNull(user);
    Preconditions.checkNotNull(roles);
    roles.stream().filter(role -> !user.getAllRoles().contains(role)).forEach(user::addRole);
  }
}
