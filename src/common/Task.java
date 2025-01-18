package src.common;

import java.util.UUID;

public abstract class Task {
  private String id;

  public Task() {
    this.id = UUID.randomUUID().toString();

    Logger.log(Logger.Level.DEBUG, "Task created with id: " + id);
  }

  public Task(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public abstract String toString();
}
