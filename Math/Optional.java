import java.util.Objects;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Predicate;

public final class Optional<T> {
    private final Supplier<? extends T> value;

    private Optional(Supplier<? extends T> value) {
        this.value = value;
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<>(() -> {
            if (Objects.nonNull(value)) {
                return value;
            }
            throw new NullPointerException();
        });
    }

    public static <T> Optional<T> ofNullable(T value) {
        return new Optional<>(() -> {
            if (Objects.nonNull(value)) {
                return value;
            }
            return null;
        });
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        return new Optional<>(() -> {
            T tmp = this.value.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(predicate) && predicate.test(tmp)) {
                return tmp;
            }
            return null;
        });
    }

    public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier) {
        return new Optional<>(() -> {
            T tmp = this.value.get();
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            if (Objects.nonNull(supplier)) {
                return supplier.get().apply(Function.identity());
            }
            return null;
        });
    }

    public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper) {
        return new Optional<>(() -> {
            T tmp = this.value.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(mapper)) {
                return mapper.apply(tmp).apply(Function.identity());
            }
            return null;
        });
    }

    public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        return new Optional<>(() -> {
            T tmp = this.value.get();
            if (Objects.nonNull(tmp) && Objects.nonNull(mapper)) {
                return mapper.apply(tmp);
            }
            return null;
        });
    }

    public <U> U apply(Function<? super T, ? extends U> mapper) {
        T tmp = this.value.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(mapper)) {
            return mapper.apply(tmp);
        }
        return null;
    }

    public T orElse(T other) {
        T tmp = this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(other)) {
            return other;
        }
        return null;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        T tmp = this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            return supplier.get();
        }
        return null;
    }

    public T orElseThrow() {
        return this.orElseThrow(NoSuchElementException::new);
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> supplier) throws X {
        T tmp = this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            throw supplier.get();
        }
        throw new NullPointerException();
    }

    public boolean isEmpty() {
        return !this.isPresent();
    }

    public boolean isPresent() {
        T tmp = this.value.get();
        return Objects.nonNull(tmp);
    }

    public void ifPresent(Consumer<? super T> action) {
        T tmp = this.value.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(action)) {
            action.accept(tmp);
        }
    }

    public void ifPresentOrElse(Consumer<? super T> action, Runnable other) {
        T tmp = this.value.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(action)) {
            action.accept(tmp);
        }
        if (Objects.nonNull(other)) {
            other.run();
        }
    }

    public int hashCode() {
        T tmp = this.value.get();
        if (Objects.nonNull(tmp)) {
            return tmp.hashCode();
        }
        return 0;
    }

    public String toString() {
        T tmp = this.value.get();
        if (Objects.nonNull(tmp)) {
            return String.format("Optional[%s]", tmp);
        }
        return String.format("Optional[%s]", "empty");
    }

    public boolean equals(Object other) {
        return Optional.ofNullable(other)
                .filter(Optional.class::isInstance)
                .map(Optional.class::cast)
                .filter(this::equals)
                .isPresent();
    }

    public boolean equals(Optional<?> other) {
        return Objects.equals(other.value.get(), this.value.get());
    }
}
