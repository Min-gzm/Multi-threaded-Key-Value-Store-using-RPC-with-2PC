package src.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
  public static enum Level {
    INFO,
    DEBUG,
    ERROR
  }

  public static void log(Level level, String message) {
    // get location of the caller
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    StackTraceElement caller = stackTrace[2];
    String className = caller.getClassName();
    String methodName = caller.getMethodName();
    int lineNumber = caller.getLineNumber();

    // generate current time and format it
    LocalDateTime now = LocalDateTime.now();
    String time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    if (level == Level.ERROR) {
      level = Level.DEBUG;
    }

    // print log
    System.out.println("[" + time + "] " + level.toString() + " | " + message + " | " + className + "." + methodName
        + ":" + lineNumber);
  }

}
