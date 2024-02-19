package event;

import java.util.*;
import java.util.function.*;

public class CStream<T> {
    private Supplier<Collection<T>> value;

    private CStream(Supplier<Collection<T>> value) {
        CStream.this.value = value;
    }

    private Collection<T> get() {
        return CStream.this.value.get();
    }

    public static <T> CStream<T> of(Collection<T> values) {
        return new CStream<>(() -> {
            if (Objects.nonNull(values)) {
                return new LinkedList<>(values);
            }
            throw new NullPointerException();
        });
    }

    public static <T> CStream<T> ofNullable(Collection<T> values) {
        return new CStream<>(() -> {
            if (Objects.nonNull(values)) {
                return new LinkedList<>(values);
            }
            return new LinkedList<>();
        });
    }

    public CStream<T> filter(Function<T, Boolean> function) {
        return new CStream<>(() -> {
            Collection<T> result = new LinkedList<>();
            for (T value : CStream.this.get()) {
                if (function.apply(value)) {
                    result.add(value);
                }
            }
            return result;
        });
    }

    public <U> CStream<U> map(Function<T, U> function) {
        return new CStream<>(() -> {
            Collection<U> result = new LinkedList<>();
            for (T value : CStream.this.get()) {
                result.add(function.apply(value));
            }
            return result;
        });
    }

    public <U> CStream<U> flatMap(Function<T, CStream<U>> function) {
        return new CStream<>(() -> {
            Collection<U> result = new LinkedList<>();
            for (T value : CStream.this.get()) {
                result.addAll(function.apply(value).get());
            }
            return result;
        });
    }
    
    public CStream<T> distinct() {
        Set<T> seen = new HashSet<>();
        return filter(seen::add);
    }

    public <U> CStream<T> distinct(Function<T, U> function) {
        Set<U> seen = new HashSet<>();
        return filter(function.andThen(seen::add));
    }

    public void forEach(Consumer<T> consumer) {
        for (T value : CStream.this.get()) {
            consumer.accept(value);
        }
    }

    public int count() {
        return CStream.this.get().size();
    }

    public boolean anyMatch(Predicate<T> predicate) {
        boolean result = false;
        for (T value : CStream.this.get()) {
            result |= predicate.test(value);
        }
        return result;
    }

    public boolean allMatch(Predicate<T> predicate) {
        boolean result = true;
        for (T value : CStream.this.get()) {
            result &= predicate.test(value);
        }
        return result;
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        T result = identity;
        for (T value : CStream.this.get()) {
            result = accumulator.apply(result, value);
        }
        return result;
    }

    public Collection<T> toCollection() {
        return CStream.this.get();
    }

    public int hashCode() {
        int result = 0;
        for (T value : CStream.this.get()) {
            result ^= value.hashCode();
        }
        return result;
    }

    public String toString() {
        return String.format("CStream[%s]", CStream.this.get());
    }

    public boolean equals(Object other) {
        return COptional.ofNullable(other)
                .filter(CStream.class::isInstance)
                .map(CStream.class::cast)
                .filter(CStream.this::equals)
                .isPresent();
    }

    private <U> boolean equals(CStream<U> other) {
        return Objects.equals(other.get(), CStream.this.get());
    }
}
