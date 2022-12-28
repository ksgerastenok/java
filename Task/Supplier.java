package event;

import java.util.Objects;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Supplier<T> {
    T get();

    static <T> Supplier<T> of(T value) {
        return () -> {
            if (Objects.nonNull(value)) {
                return value;
            }
            throw new NullPointerException();
        };
    }

    static <T> Supplier<T> ofNullable(T value) {
        return () -> {
            if (Objects.nonNull(value)) {
                return value;
            }
            return null;
        };
    }

    default Supplier<T> or(Supplier<T> supplier) {
        return () -> {
            T tmp = this.get();
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            if (Objects.nonNull(supplier)) {
                return supplier.get();
            }
            return null;
        };
    }

    default Supplier<T> filter(Predicate<T> predicate) {
        return () -> {
            T tmp = this.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(predicate) && predicate.test(tmp)) {
                return tmp;
            }
            return null;
        };
    }

    default <U> Supplier<U> flatMap(Function<T, Supplier<U>> function) {
        return () -> {
            T tmp = this.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(function)) {
                return function.apply(tmp).get();
            }
            return null;
        };
    }

    default <U> Supplier<U> map(Function<T, U> function) {
        return () -> {
            T tmp = this.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(function)) {
                return function.apply(tmp);
            }
            return null;
        };
    }

    default <U> U apply(Function<T, U> function) {
        T tmp = this.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(function)) {
            return function.apply(tmp);
        }
        return null;
    }

    default T orElse(T other) {
        T tmp = this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(other)) {
            return other;
        }
        return null;
    }

    default T orElse(Supplier<T> supplier) {
        T tmp = this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            return supplier.get();
        }
        return null;
    }

    default T orElseThrow() {
        return this.orElseThrow(NoSuchElementException::new);
    }

    default <X extends Throwable> T orElseThrow(Supplier<X> supplier) throws X {
        T tmp = this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            throw supplier.get();
        }
        throw new NullPointerException();
    }

    default boolean isEmpty() {
        return !this.isPresent();
    }

    default boolean isPresent() {
        T tmp = this.get();
        return Objects.nonNull(tmp);
    }

    default void ifPresent(Consumer<T> consumer) {
        T tmp = this.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(consumer)) {
            consumer.accept(tmp);
        }
    }

    default void ifPresent(Consumer<T> consumer, Runnable other) {
        T tmp = this.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(consumer)) {
            consumer.accept(tmp);
        }
        if (Objects.nonNull(other)) {
            other.run();
        }
    }

    default int code() {
        T tmp = this.get();
        if (Objects.nonNull(tmp)) {
            return tmp.hashCode();
        }
        return 0;
    }

    default String name() {
        T tmp = this.get();
        if (Objects.nonNull(tmp)) {
            return String.format("%s[%s]", this.getClass().getSimpleName(), tmp);
        }
        return String.format("%s[%s]", this.getClass().getSimpleName(), "empty");
    }

    default boolean equal(Object other) {
        return Supplier.ofNullable(other)
                .filter(Supplier.class::isInstance)
                .map(Supplier.class::cast)
                .filter(this::equal)
                .isPresent();
    }

    default <U> boolean equal(Supplier<U> other) {
        return Objects.equals(other.get(), this.get());
    }
}
