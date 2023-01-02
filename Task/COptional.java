import java.util.Objects;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

final class COptional<T> {
    private final Supplier<T> value;

    private COptional(Supplier<T> value) {
        this.value = value;
    }

    public static <T> COptional<T> of(T value) {
        return new COptional<>(() -> {
            T tmp = value;
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            throw new NullPointerException();
        });
    }

    public static <T> COptional<T> ofNullable(T value) {
        return new COptional<>(() -> {
            T tmp = value;
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            return null;
        });
    }

    public COptional<T> or(COptional<T> other) {
        return new COptional<>(() -> {
            T tmp = COptional.this.value.get();
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            if (Objects.nonNull(other)) {
                return other.value.get();
            }
            return null;
        });
    }

    public COptional<T> or(Supplier<COptional<T>> supplier) {
        return new COptional<>(() -> {
            T tmp = COptional.this.value.get();
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            if (Objects.nonNull(supplier)) {
                return supplier.get().value.get();
            }
            return null;
        });
    }

    public COptional<T> filter(Function<T, Boolean> function) {
        return new COptional<>(() -> {
            T tmp = COptional.this.value.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(function) && function.apply(tmp)) {
                return tmp;
            }
            return null;
        });
    }

    public <U> COptional<U> flatMap(Function<T, COptional<U>> function) {
        return new COptional<>(() -> {
            T tmp = COptional.this.value.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(function)) {
                return function.apply(tmp).value.get();
            }
            return null;
        });
    }

    public <U> COptional<U> map(Function<T, U> function) {
        return new COptional<>(() -> {
            T tmp = COptional.this.value.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(function)) {
                return function.apply(tmp);
            }
            return null;
        });
    }

    public T orElse(T other) {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(other)) {
            return other;
        }
        return null;
    }

    public T orElse(Supplier<T> supplier) {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            return supplier.get();
        }
        return null;
    }

    public T orElseThrow() {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        throw new NoSuchElementException("No value present");
    }

    public <U extends Throwable> T orElseThrow(U throwable) throws U {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(throwable)) {
            throw throwable;
        }
        throw new NullPointerException();
    }

    public <U extends Throwable> T orElseThrow(Supplier<U> supplier) throws U {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            throw supplier.get();
        }
        throw new NullPointerException();
    }

    public boolean isEmpty() {
        return !COptional.this.isPresent();
    }

    public boolean isPresent() {
        T tmp = COptional.this.value.get();
        return Objects.nonNull(tmp);
    }

    public void ifPresent(Consumer<T> consumer) {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(consumer)) {
            consumer.accept(tmp);
        }
    }

    public void ifPresent(Consumer<T> consumer, Runnable runnable) {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(consumer)) {
            consumer.accept(tmp);
        }
        if (Objects.nonNull(runnable)) {
            runnable.run();
        }
    }

    public int hashCode() {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp.hashCode();
        }
        return 0;
    }

    public String toString() {
        T tmp = COptional.this.value.get();
        if (Objects.nonNull(tmp)) {
            return String.format("COptional[%s]", tmp);
        }
        return String.format("COptional[%s]", "empty");
    }

    public boolean equals(Object other) {
        return COptional.ofNullable(other)
                .filter(COptional.class::isInstance)
                .map(COptional.class::cast)
                .filter(COptional.this::equals)
                .isPresent();
    }

    private <U> boolean equals(COptional<U> other) {
        return Objects.equals(other.value.get(), COptional.this.value.get());
    }
}
