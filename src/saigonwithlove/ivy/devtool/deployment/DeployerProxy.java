package saigonwithlove.ivy.devtool.deployment;

import ch.ivyteam.ivy.application.IProcessModelVersion;

public interface DeployerProxy {
  void deploy(IProcessModelVersion pmv);
}
