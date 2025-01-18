package src.common;

import java.io.Serializable;

public class KVOperation implements Serializable {
  public enum Action {
    GET,
    PUT,
    DELETE
  }

  private Action action;
  private String key;
  private String value;

  public KVOperation(Action action, String key) {
    this.action = action;
    this.key = key;

    Logger.log(Logger.Level.DEBUG, "New KVOperation created: " + this);
  }

  public KVOperation(Action action, String key, String value) {
    this.action = action;
    this.key = key;
    this.value = value;

    Logger.log(Logger.Level.DEBUG, "New KVOperation created: " + this);
  }

  public Action getAction() {
    return action;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public KVOperation rollback() {
    if (action == Action.PUT) {
      this.action = Action.DELETE;
    } else if (action == Action.DELETE) {
      this.action = Action.PUT;
    }

    return this;
  }

  public String toString() {
    return "KVOperation: " + action + " " + key + " " + value;
  }
}
