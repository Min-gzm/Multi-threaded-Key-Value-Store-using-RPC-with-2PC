package src.common;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class RpcClient<T> {
  private T service;
  private String serviceName;
  private HostInfo hostInfo;

  public RpcClient(HostInfo hostInfo, String serviceName) {
    this.service = null;
    this.hostInfo = hostInfo;
    this.serviceName = serviceName;
    lookup();
  }

  @SuppressWarnings("unchecked")
  private void lookup() {
    try {
      Registry registry = LocateRegistry.getRegistry(hostInfo.getHost(), hostInfo.getPort());
      this.service = (T) registry.lookup(serviceName);
    } catch (Exception e) {
      Logger.log(Logger.Level.ERROR, "Failed to lookup " + serviceName + " service: " + e.getMessage());
    }
  }

  public boolean isConnected() {
    return service != null;
  }

  public T getService() {
    return service;
  }
}
