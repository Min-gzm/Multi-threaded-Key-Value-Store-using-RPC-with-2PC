package src.common;

public class KVTask extends Task {
  private KVOperation operation;
  private HostInfo coordinatorHostInfo;
  private boolean isRollback;

  public KVTask(String id, KVOperation operation, HostInfo coordinatorHostInfo, boolean isRollback) {
    super(id);
    this.operation = operation;
    this.coordinatorHostInfo = coordinatorHostInfo;
    this.isRollback = isRollback;
  }

  public KVTask(String id, KVOperation operation, HostInfo coordinatorHostInfo) {
    this(id, operation, coordinatorHostInfo, false);
  }

  public KVOperation getKVOperation() {
    return operation;
  }

  public HostInfo getCoordinatorHostInfo() {
    return coordinatorHostInfo;
  }

  public boolean isRollback() {
    return isRollback;
  }

  public String toString() {
    return "KVTask: " + getId() + " " + operation.toString() + " " + coordinatorHostInfo.toString() + " "
        + isRollback;
  }
}
