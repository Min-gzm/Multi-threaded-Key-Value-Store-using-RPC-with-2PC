package src.common;

import java.io.Serializable;

public class HostInfo implements Serializable {
  private String host;
  private int port;

  public HostInfo(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public String getHost() {
    return host;
  }

  public int getPort() {
    return port;
  }

  public String toString() {
    return host + ":" + port;
  }
}
