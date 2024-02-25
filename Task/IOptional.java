package event;

import java.util.*;
import java.util.function.*;

public interface IOptional<T> extends Supplier<T> {
    static <T> IOptional<T> of(T value) {
        return () -> Objects.requireNonNull(value);
    }

    static <T> IOptional<T> ofNullable(T value) {
        return () -> value;
    }

    default IOptional<T> or(IOptional<T> other) {
        return () -> {
            T result = IOptional.this.get();
            if (Objects.nonNull(result)) {
                return result;
            } else {
                return Objects.requireNonNull(other).get();
            }
        };
    }

    default IOptional<T> filter(Function<T, Boolean> function) {
        return () -> {
            T result = IOptional.this.get();
            if (Objects.nonNull(result)) {
                return Objects.requireNonNull(function).apply(result) ? result : null;
            } else {
                return null;
            }
        };
    }

    default <U> IOptional<U> flatMap(Function<T, IOptional<U>> function) {
        return () -> {
            T result = IOptional.this.get();
            if (Objects.nonNull(result)) {
                return Objects.requireNonNull(function).apply(result).get();
            } else {
                return null;
            }
        };
    }

    default <U> IOptional<U> map(Function<T, U> function) {
        return () -> {
            T result = IOptional.this.get();
            if (Objects.nonNull(result)) {
                return Objects.requireNonNull(function).apply(result);
            } else {
                return null;
            }
        };
    }

    default T orElse(T other) {
        T result = IOptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            return other;
        }
    }

    default T orElseThrow() {
        T result = IOptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            throw new NullPointerException();
        }
    }

    default <E extends Exception> T orElseThrow(E exception) throws E {
        T result = IOptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            throw Objects.requireNonNull(exception);
        }
    }

    default boolean isEmpty() {
        T result = IOptional.this.get();
        return Objects.isNull(result);
    }

    default boolean isPresent() {
        T result = IOptional.this.get();
        return Objects.nonNull(result);
    }

    default void ifPresent(Consumer<T> consumer) {
        T result = IOptional.this.get();
        if (Objects.nonNull(result)) {
            Objects.requireNonNull(consumer).accept(result);
        }
    }

    default void ifPresent(Consumer<T> consumer, Runnable runnable) {
        T result = IOptional.this.get();
        if (Objects.nonNull(result)) {
            Objects.requireNonNull(consumer).accept(result);
        } else {
            Objects.requireNonNull(runnable).run();
        }
    }

    default int hash() {
        T result = IOptional.this.get();
        if (Objects.nonNull(result)) {
            return result.hashCode();
        } else {
            return 0;
        }
    }

    default String string() {
        T result = IOptional.this.get();
        if (Objects.nonNull(result)) {
            return String.format("IOptional[%s]", result);
        } else {
            return String.format("IOptional[%s]", "empty");
        }
    }

    default boolean equal(Object other) {
        return IOptional.ofNullable(other)
                .filter(IOptional.class::isInstance)
                .map(IOptional.class::cast)
                .filter(IOptional.this::equal)
                .isPresent();
    }

    private <U> boolean equal(IOptional<U> other) {
        return Objects.equals(other.get(), IOptional.this.get());
    }
}
