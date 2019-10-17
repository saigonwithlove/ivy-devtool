package saigonwithlove.ivy.devtool.automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class InitializationModel {
  private List<User> users = new ArrayList<>();
  private List<GlobalVariable> globalVariables = new ArrayList<>();
  private List<ServerProperty> serverProperties = new ArrayList<>();

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public List<GlobalVariable> getGlobalVariables() {
    return globalVariables;
  }

  public void setGlobalVariables(List<GlobalVariable> globalVariables) {
    this.globalVariables = globalVariables;
  }

  public List<ServerProperty> getServerProperties() {
    return serverProperties;
  }

  public void setServerProperties(List<ServerProperty> serverProperties) {
    this.serverProperties = serverProperties;
  }

  public static class User {

    private String userName;
    private String password;

    public User(String token) {
      String[] params = StringUtils.split(token, ":");
      this.userName = params[0];
      this.password = params[1];
    }

    public String getPassword() {
      return password;
    }

    public String getUserName() {
      return userName;
    }
  }

  public static class GlobalVariable {
    private String name;
    private String value;

    public GlobalVariable(String token) {
      Iterator<String> params = Arrays.asList(StringUtils.split(token, ":")).iterator();
      this.name = params.next();
      this.value = StringUtils.join(params, ":");
    }

    public String getName() {
      return name;
    }

    public String getValue() {
      return value;
    }
  }

  public static class ServerProperty {
    private String name;
    private String value;

    public ServerProperty(String token) {
      String[] params = StringUtils.split(token, ":");
      this.name = params[0];
      this.value = params[1];
    }

    public String getName() {
      return name;
    }

    public String getValue() {
      return value;
    }
  }
}
