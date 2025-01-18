package src.common;

import java.util.ArrayList;

public class Utils {
  public static ServerStartParams parseServerStartParams(String request) {
    // command: java -cp out src.app.Servers --host=192.168.1.10 --port=8080
    // --servers=192.168.1.11:8080,192.168.1.12:8080

    try {
      String[] params = request.split(" ");
      String host = null;
      Integer port = null;
      ArrayList<HostInfo> peers = new ArrayList<>();

      for (String param : params) {
        if (param.startsWith("--host")) {
          host = param.split("=")[1];
        } else if (param.startsWith("--port")) {
          port = Integer.parseInt(param.split("=")[1]);
        } else if (param.startsWith("--peers")) {
          String[] peersStr = param.split("=")[1].split(",");
          for (String peer : peersStr) {
            String[] hostAndPort = peer.split(":");
            peers.add(new HostInfo(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
          }
        }
      }

      return new ServerStartParams(host, port, peers);
    } catch (Exception e) {
      System.out.println("Error parsing server start params: " + e.getMessage());
      return null;
    }
  }

  public static class ServerStartParams {
    private String host;
    private Integer port;
    private ArrayList<HostInfo> peers;

    public ServerStartParams(String host, Integer port, ArrayList<HostInfo> peers) {
      this.host = host;
      this.port = port;
      this.peers = peers;
    }

    public String getHost() {
      return host;
    }

    public Integer getPort() {
      return port;
    }

    public ArrayList<HostInfo> getPeers() {
      return peers;
    }
  }
}
