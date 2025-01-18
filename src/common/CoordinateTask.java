package src.common;

public class CoordinateTask extends Task {
  private KVOperation operation;
  private Action action;

  public enum Action {
    READY,
    ABORT,
    ACK,
    NACK,
    COOR,
    GET,
  }

  public CoordinateTask(KVOperation operation, Action action) {
    super();
    this.operation = operation;
    this.action = action;
  }

  public CoordinateTask(String id, KVOperation operation, Action action) {
    super(id);
    this.operation = operation;
    this.action = action;
  }

  public KVOperation getKVOperation() {
    return operation;
  }

  public Action getAction() {
    return action;
  }

  public String toString() {
    return "CoordinateTask: " + getId() + " " + operation.toString() + " " + action;
  }
}
