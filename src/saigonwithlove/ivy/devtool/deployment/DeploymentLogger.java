package saigonwithlove.ivy.devtool.deployment;

import ch.ivyteam.ivy.deployment.IDeploymentLogger;
import ch.ivyteam.log.ILogger;

public class DeploymentLogger implements IDeploymentLogger {
  private ILogger logger;

  public DeploymentLogger(ILogger logger) {
    this.logger = logger;
  }

  @Override
  public void info(String message) {
    logger.info(message);
  }

  @Override
  public void info(String message, Throwable throwable) {
    logger.info(message, throwable);
  }

  @Override
  public void warning(String message) {
    logger.warn(message);
  }

  @Override
  public void warning(String message, Throwable throwable) {
    logger.warn(message, throwable);
  }

  @Override
  public void error(String message) {
    logger.error(message);
  }

  @Override
  public void error(String message, Throwable throwable) {
    logger.error(message, throwable);
  }
}
