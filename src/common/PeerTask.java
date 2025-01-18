package src.common;

public class PeerTask extends Task {
  private KVOperation operation;
  private Action action;
  private HostInfo coordinatorHostInfo;

  public enum Action {
    PREPARE,
    COMMIT,
    ROLLBACK,
    SUCCESS,
    ERROR,
    READ,
    WRITE
  }

  public PeerTask(String id, KVOperation operation, HostInfo coordinatorHostInfo, Action action) {
    super(id);
    this.operation = operation;
    this.coordinatorHostInfo = coordinatorHostInfo;
    this.action = action;
  }

  public KVOperation getKVOperation() {
    return operation;
  }

  public Action getAction() {
    return action;
  }

  public HostInfo getCoordinatorHostInfo() {
    return coordinatorHostInfo;
  }

  public String toString() {
    return "PeerTask: " + getId() + " " + operation.toString() + " " + coordinatorHostInfo.toString() + " "
        + action;
  }
}
