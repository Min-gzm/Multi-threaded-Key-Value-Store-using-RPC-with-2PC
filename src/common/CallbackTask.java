package src.common;

public class CallbackTask extends Task {
  private KVOperation operation;
  private HostInfo clientHostInfo;
  private Action action;

  public enum Action {
    SUCCESS,
    ERROR,
    PENDING,
    TIMEOUT
  }

  public CallbackTask(String id, KVOperation operation, HostInfo clientHostInfo, Action action) {
    super(id);
    this.operation = operation;
    this.clientHostInfo = clientHostInfo;
    this.action = action;
  }

  public KVOperation getKVOperation() {
    return operation;
  }

  public HostInfo getClientHostInfo() {
    return clientHostInfo;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public String toString() {
    return "CallbackTask: " + getId() + " " + operation.toString() + " " + clientHostInfo.toString() + " "
        + action;
  }
}