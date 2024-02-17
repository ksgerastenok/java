package event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.*;

public abstract class AStream<T> implements Supplier<Collection<T>> {
    public static <T> AStream<T> of(Collection<T> values) {
        return new AStream<>() {
            public Collection<T> get() {
                if (Objects.nonNull(values)) {
                    return new ArrayList<>(values);
                }
                throw new NullPointerException();
            }
        };
    }

    public static <T> AStream<T> ofNullable(Collection<T> values) {
        return new AStream<>() {
            public Collection<T> get() {
                if (Objects.nonNull(values)) {
                    return new ArrayList<>(values);
                }
                return new ArrayList<>();
            }
        };
    }

    public AStream<T> filter(Function<T, Boolean> function) {
        return new AStream<>() {
            public Collection<T> get() {
                Collection<T> result = new ArrayList<>();
                if (Objects.nonNull(function)) {
                    for (T value : AStream.this.get()) {
                        if (function.apply(value)) {
                            result.add(value);
                        }
                    }
                }
                return result;
            }
        };
    }

    public <U> AStream<U> map(Function<T, U> function) {
        return new AStream<>() {
            public Collection<U> get() {
                Collection<U> result = new ArrayList<>();
                if (Objects.nonNull(function)) {
                    for (T value : AStream.this.get()) {
                        result.add(function.apply(value));
                    }
                }
                return result;
            }
        };
    }

    public <U> AStream<U> flatMap(Function<T, AStream<U>> function) {
        return new AStream<>() {
            public Collection<U> get() {
                Collection<U> result = new ArrayList<>();
                if (Objects.nonNull(function)) {
                    for (T value : AStream.this.get()) {
                        result.addAll(function.apply(value).get());
                    }
                }
                return result;
            }
        };
    }

    public void forEach(Consumer<T> consumer) {
        if (Objects.nonNull(consumer)) {
            for (T value : AStream.this.get()) {
                consumer.accept(value);
            }
        }
        return;
    }

    public int count() {
        return AStream.this.get().size();
    }

    public boolean anyMatch(Predicate<T> predicate) {
        boolean result = false;
        for (T value : AStream.this.get()) {
            result |= predicate.test(value);
        }
        return result;
    }

    public boolean allMatch(Predicate<T> predicate) {
        boolean result = true;
        for (T value : AStream.this.get()) {
            result &= predicate.test(value);
        }
        return result;
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        T result = identity;
        for (T value : AStream.this.get()) {
            result = accumulator.apply(result, value);
        }
        return result;
    }

    public Collection<T> toCollection() {
        return AStream.this.get();
    }

    public int hashCode() {
        int result = 0;
        for (T value : AStream.this.get()) {
            result ^= value.hashCode();
        }
        return result;
    }

    public String toString() {
        return String.format("AStream[%s]", AStream.this.get());
    }

    public boolean equals(Object other) {
        return COptional.ofNullable(other)
                .filter(AStream.class::isInstance)
                .map(AStream.class::cast)
                .filter(AStream.this::equals)
                .isPresent();
    }

    public <U> boolean equals(AStream<U> other) {
        return Objects.nonNull(other) && Objects.equals(other.get(), AStream.this.get());
    }
}
