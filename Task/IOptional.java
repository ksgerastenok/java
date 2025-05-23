package event;

import java.util.*;
import java.util.function.*;

interface Optional<T> extends Supplier<T> {
  static <T> Optional<T> ofNullable(T value) {
    return () -> value;
  }

  static <T> Optional<T> of(T value) {
    return () -> Objects.requireNonNull(value);
  }

  static <T> Optional<T> or(Optional<T> optional, Optional<T> other) {
    return () -> {
      T value = Objects.requireNonNull(optional).get();
      if (Objects.nonNull(value)) {
        return value;
      } else {
        return Objects.requireNonNull(other).get();
      }
    };
  }

  static <T, R> Optional<R> map(Optional<T> optional, Function<T, R> function) {
    return () -> {
      T value = Objects.requireNonNull(optional).get();
      if (Objects.nonNull(value)) {
        return Objects.requireNonNull(function).apply(value);
      } else {
        return null;
      }
    };
  }

  static <T, R> Optional<R> flatMap(Optional<T> optional, Function<T, Optional<R>> function) {
    return () -> {
      T value = Objects.requireNonNull(optional).get();
      if (Objects.nonNull(value)) {
        return Objects.requireNonNull(Objects.requireNonNull(function).apply(value)).get();
      } else {
        return null;
      }
    };
  }

  static <T> Optional<T> filter(Optional<T> optional, Predicate<T> predicate) {
    return () -> {
      T value = Objects.requireNonNull(optional).get();
      if (Objects.nonNull(value)) {
        return Objects.requireNonNull(predicate).test(value) ? value : null;
      } else {
        return null;
      }
    };
  }

  static <T> boolean isPresent(Optional<T> optional) {
    T value = Objects.requireNonNull(optional).get();
    return Objects.nonNull(value);
  }

  static <T> T orElse(Optional<T> optional, T other) {
    T value = Objects.requireNonNull(optional).get();
    if (Objects.nonNull(value)) {
      return value;
    } else {
      return other;
    }
  }

  static <T> T orElse(Optional<T> optional, Supplier<T> other) {
    T value = Objects.requireNonNull(optional).get();
    if (Objects.nonNull(value)) {
      return value;
    } else {
      return Objects.requireNonNull(other).get();
    }
  }

  static <T> T orElseThrow(Optional<T> optional) {
    T value = Objects.requireNonNull(optional).get();
    if (Objects.nonNull(value)) {
      return value;
    } else {
      throw new NullPointerException();
    }
  }

  static <T, E extends Exception> T orElseThrow(Optional<T> optional, E exception) throws E {
    T value = Objects.requireNonNull(optional).get();
    if (Objects.nonNull(value)) {
      return value;
    } else {
      throw Objects.requireNonNull(exception);
    }
  }

  static <T, E extends Exception> T orElseThrow(Optional<T> optional, Supplier<E> exception) throws E {
    T value = Objects.requireNonNull(optional).get();
    if (Objects.nonNull(value)) {
      return value;
    } else {
      throw Objects.requireNonNull(exception).get();
    }
  }

  static <T> void ifPresent(Optional<T> optional, Consumer<T> consumer) {
    T value = Objects.requireNonNull(optional).get();
    if (Objects.nonNull(value)) {
      Objects.requireNonNull(consumer).accept(value);
    } else {
      return;
    }
  }

  static <T> void ifPresent(Optional<T> optional, Consumer<T> consumer, Runnable runnable) {
    T value = Objects.requireNonNull(optional).get();
    if (Objects.nonNull(value)) {
      Objects.requireNonNull(consumer).accept(value);
    } else {
      Objects.requireNonNull(runnable).run();
    }
  }

  default Optional<T> or(Optional<T> other) {
    return Optional.or(this, other);
  }

  default <R> Optional<R> map(Function<T, R> function) {
    return Optional.map(this, function);
  }

  default <R> Optional<R> flatMap(Function<T, Optional<R>> function) {
    return Optional.flatMap(this, function);
  }

  default Optional<T> filter(Predicate<T> predicate) {
    return Optional.filter(this, predicate);
  }

  default boolean isPresent() {
    return Optional.isPresent(this);
  }

  default T orElse(T other) {
    return Optional.orElse(this, other);
  }

  default T orElse(Supplier<T> other) {
    return Optional.orElse(this, other);
  }

  default T orElseThrow() {
    return Optional.orElseThrow(this);
  }

  default <E extends Exception> T orElseThrow(E exception) throws E {
    return Optional.orElseThrow(this, exception);
  }

  default <E extends Exception> T orElseThrow(Supplier<E> exception) throws E {
    return Optional.orElseThrow(this, exception);
  }

  default void ifPresent(Consumer<T> consumer) {
    Optional.ifPresent(this, consumer);
  }

  default void ifPresent(Consumer<T> consumer, Runnable runnable) {
    Optional.ifPresent(this, consumer, runnable);
  }
}
