package src.common;

public interface IListener<T> {
  void onSuccess(T input);

  void onError(String error);
}
