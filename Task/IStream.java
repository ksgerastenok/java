package event;

import java.util.*;
import java.util.function.*;

public interface IStream<T> extends Supplier<Collection<T>> {
    static <T> IStream<T> of(Collection<T> values) {
        return () -> {
            if (Objects.nonNull(values)) {
                return new LinkedList<>(values);
            }
            throw new NullPointerException();
        };
    }

    static <T> IStream<T> ofNullable(Collection<T> values) {
        return () -> {
            if (Objects.nonNull(values)) {
                return new LinkedList<>(values);
            }
            return new LinkedList<>();
        };
    }

    default IStream<T> filter(Function<T, Boolean> function) {
        return () -> {
            Collection<T> result = new LinkedList<>();
            for (T value : IStream.this.get()) {
                if (Objects.requireNonNull(function).apply(value)) {
                    result.add(value);
                }
            }
            return result;
        };
    }

    default <U> IStream<U> map(Function<T, U> function) {
        return () -> {
            Collection<U> result = new LinkedList<>();
            for (T value : IStream.this.get()) {
                result.add(Objects.requireNonNull(function).apply(value));
            }
            return result;
        };
    }

    default <U> IStream<U> flatMap(Function<T, IStream<U>> function) {
        return () -> {
            Collection<U> result = new LinkedList<>();
            for (T value : IStream.this.get()) {
                result.addAll(Objects.requireNonNull(function).apply(value).get());
            }
            return result;
        };
    }

    default IStream<T> distinct() {
        Set<T> seen = new HashSet<>();
        return IStream.this.filter(seen::add);
    }

    default <U> IStream<T> distinct(Function<T, U> function) {
        Set<U> seen = new HashSet<>();
        return IStream.this.filter(Objects.requireNonNull(function).andThen(seen::add));
    }

    default void forEach(Consumer<T> consumer) {
        for (T value : IStream.this.get()) {
            Objects.requireNonNull(consumer).accept(value);
        }
    }

    default int count() {
        return IStream.this.get().size();
    }

    default boolean anyMatch(Predicate<T> predicate) {
        boolean result = false;
        for (T value : IStream.this.get()) {
            result |= Objects.requireNonNull(predicate).test(value);
        }
        return result;
    }

    default boolean allMatch(Predicate<T> predicate) {
        boolean result = true;
        for (T value : IStream.this.get()) {
            result &= Objects.requireNonNull(predicate).test(value);
        }
        return result;
    }

    default T reduce(T identity, BinaryOperator<T> accumulator) {
        T result = Objects.requireNonNull(identity);
        for (T value : IStream.this.get()) {
            result = Objects.requireNonNull(accumulator).apply(result, value);
        }
        return result;
    }

    default Collection<T> toCollection() {
        return IStream.this.get();
    }

    default int hash() {
        int result = 0;
        for (T value : IStream.this.get()) {
            result ^= value.hashCode();
        }
        return result;
    }

    default String string() {
        return String.format("IStream[%s]", IStream.this.get());
    }

    default boolean equal(Object other) {
        return IOptional.ofNullable(other)
                .filter(IStream.class::isInstance)
                .map(IStream.class::cast)
                .filter(IStream.this::equal)
                .isPresent();
    }

    private <U> boolean equal(IStream<U> other) {
        return Objects.equals(other.get(), IStream.this.get());
    }
}
