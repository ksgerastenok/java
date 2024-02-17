package event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.*;

public class CStream<T> {
    private Supplier<List<T>> value;

    private CStream(Supplier<List<T>> value) {
        CStream.this.value = value;
    }

    private List<T> get() {
        return CStream.this.value.get();
    }

    public static <T> CStream<T> of(Collection<T> values) {
        return new CStream<>(() -> {
            if (Objects.nonNull(values)) {
                return new ArrayList<>(values);
            }
            throw new NullPointerException();
        });
    }

    public static <T> CStream<T> ofNullable(Collection<T> values) {
        return new CStream<>(() -> {
            if (Objects.nonNull(values)) {
                return new ArrayList<>(values);
            }
            return new ArrayList<>();
        });
    }

    public CStream<T> filter(Function<T, Boolean> function) {
        return new CStream<>(() -> {
            List<T> result = new ArrayList<>();
            if (Objects.nonNull(function)) {
                for (T value : CStream.this.get()) {
                    if (function.apply(value)) {
                        result.add(value);
                    }
                }
            }
            return result;
        });
    }

    public <U> CStream<U> map(Function<T, U> function) {
        return new CStream<>(() -> {
            List<U> result = new ArrayList<>();
            if (Objects.nonNull(function)) {
                for (T value : CStream.this.get()) {
                    result.add(function.apply(value));
                }
            }
            return result;
        });
    }

    public <U> CStream<U> flatMap(Function<T, CStream<U>> function) {
        return new CStream<>(() -> {
            List<U> result = new ArrayList<>();
            if (Objects.nonNull(function)) {
                for (T value : CStream.this.get()) {
                    result.addAll(function.apply(value).get());
                }
            }
            return result;
        });
    }



    public void forEach(Consumer<T> consumer) {
        if (Objects.nonNull(consumer)) {
            for (T value : CStream.this.get()) {
                consumer.accept(value);
            }
        }
        return;
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

    public List<T> toList() {
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

    public <U> boolean equals(CStream<U> other) {
        return Objects.nonNull(other) && Objects.equals(other.get(), CStream.this.get());
    }
}
