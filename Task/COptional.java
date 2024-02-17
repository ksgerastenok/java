import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

final class COptional<T> {
    private Supplier<T> value;

    private COptional(Supplier<T> value) {
        COptional.this.value = value;
    }

    private T get() {
        return COptional.this.value.get();
    }

    public static <T> COptional<T> of(T value) {
        return new COptional<>(() -> {
            T result = value;
            if (Objects.nonNull(result)) {
                return result;
            } else {
                throw new NullPointerException();
            }
        });
    }

    public static <T> COptional<T> ofNullable(T value) {
        return new COptional<>(() -> {
            T result = value;
            if (Objects.nonNull(result)) {
                return result;
            } else {
                return null;
            }
        });
    }

    public COptional<T> or(COptional<T> other) {
        return new COptional<>(() -> {
            T result = COptional.this.get();
            if (Objects.nonNull(result)) {
                return result;
            } else {
                return other.get();
            }
        });
    }

    public COptional<T> filter(Function<T, Boolean> function) {
        return new COptional<>(() -> {
            T result = COptional.this.get();
            if (Objects.nonNull(function) && Objects.nonNull(result) && function.apply(result)) {
                return result;
            } else {
                return null;
            }
        });
    }

    public <U> COptional<U> flatMap(Function<T, COptional<U>> function) {
        return new COptional<>(() -> {
            T result = COptional.this.get();
            if (Objects.nonNull(function) && Objects.nonNull(result)) {
                return function.apply(result).get();
            } else {
                return null;
            }
        });
    }

    public <U> COptional<U> map(Function<T, U> function) {
        return new COptional<>(() -> {
            T result = COptional.this.get();
            if (Objects.nonNull(function) && Objects.nonNull(result)) {
                return function.apply(result);
            } else {
                return null;
            }
        });
    }

    public T orElse(T other) {
        T result = COptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            return other;
        }
    }

    public T orElseThrow() {
        T result = COptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            throw new NullPointerException();
        }
    }

    public <E extends Exception> T orElseThrow(E exception) throws E {
        T result = COptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            throw exception;
        }
    }

    public boolean isEmpty() {
        T result = COptional.this.get();
        return Objects.isNull(result);
    }

    public boolean isPresent() {
        T result = COptional.this.get();
        return Objects.nonNull(result);
    }

    public void ifPresent(Consumer<T> consumer) {
        T result = COptional.this.get();
        if (Objects.nonNull(consumer) && Objects.nonNull(result)) {
            consumer.accept(result);
        }
        return;
    }

    public void ifPresent(Consumer<T> consumer, Runnable runnable) {
        T result = COptional.this.get();
        if (Objects.nonNull(consumer) && Objects.nonNull(result)) {
            consumer.accept(result);
        } else {
            runnable.run();
        }
        return;
    }

    public int hashCode() {
        T result = COptional.this.get();
        if (Objects.nonNull(result)) {
            return result.hashCode();
        } else {
            return 0;
        }
    }

    public String toString() {
        T result = COptional.this.get();
        if (Objects.nonNull(result)) {
            return String.format("COptional[%s]", result);
        } else {
            return String.format("COptional[%s]", "empty");
        }
    }

    public boolean equals(Object other) {
        return COptional.ofNullable(other)
                .filter(COptional.class::isInstance)
                .map(COptional.class::cast)
                .filter(COptional.this::equals)
                .isPresent();
    }

    public <U> boolean equals(COptional<U> other) {
        return Objects.nonNull(other) && Objects.equals(other.get(), COptional.this.get());
    }
}
