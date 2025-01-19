package src.common;

import java.util.Map;
import java.util.HashMap;

public class SpinLocks {
  private Map<String, Long> locks;

  public SpinLocks() {
    this.locks = new HashMap<>();
    Logger.log(Logger.Level.DEBUG, "New SpinLocks created");
  }

  public boolean lock(String id) {
    long startTime = System.currentTimeMillis();

    while (true) {
      if (!locks.containsKey(id)) {
        locks.put(id, System.currentTimeMillis());
        return true;
      }

      if (System.currentTimeMillis() - startTime > 3000) {
        Logger.log(Logger.Level.ERROR, "Fail to get the lock: target id is " + id);
        return false;
      }
    }
  }

  public boolean lockWithoutTimeout(String id) {
    while (true) {
      if (!locks.containsKey(id)) {
        locks.put(id, System.currentTimeMillis());
        Logger.log(Logger.Level.DEBUG, "Get the lock: " + id);
        return true;
      }
    }
  }

  public boolean hasLock(String id) {
    return locks.containsKey(id);
  }

  public void unlock(String id) {
    if (locks.containsKey(id)) {
      locks.remove(id);
    } else {
      Logger.log(Logger.Level.ERROR, "Fail to unlock the lock: target key is " + id);
      throw new RuntimeException("Fail to unlock the lock: target key is " + id);
    }
  }
}