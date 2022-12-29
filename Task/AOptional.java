import java.util.Objects;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Predicate;

abstract class AOptional<T> implements Supplier<T> {
    public static <T> AOptional<T> of(T value) {
        return new AOptional<>() {
            public T get() {
                T tmp = value;
                if (Objects.nonNull(tmp)) {
                    return tmp;
                }
                throw new NullPointerException();            }
        };
    }

    public static <T> AOptional<T> ofNullable(T value) {
        return new AOptional<>() {
            public T get() {
                T tmp = value;
                if (Objects.nonNull(tmp)) {
                    return tmp;
                }
                return null;            }
        };
    }

    public AOptional<T> filter(Predicate<T> predicate) {
        return new AOptional<>() {
            public T get() {
                T tmp = AOptional.this.get();
                if (Objects.nonNull(tmp) && Objects.nonNull(predicate) && predicate.test(tmp)) {
                    return tmp;
                }
                return null;
            }
        };
    }

    public AOptional<T> or(AOptional<T> other) {
        return new AOptional<>() {
            public T get() {
                T tmp = AOptional.this.get();
                if (Objects.nonNull(tmp)) {
                    return tmp;
                }
                if (Objects.nonNull(other)) {
                    return other.get();
                }
                return null;
            }
        };
    }

    public AOptional<T> or(Supplier<AOptional<T>> supplier) {
        return new AOptional<>() {
            public T get() {
                T tmp = AOptional.this.get();
                if (Objects.nonNull(tmp)) {
                    return tmp;
                }
                if (Objects.nonNull(supplier)) {
                    return supplier.get().get();
                }
                return null;
            }
        };
    }

    public <U> AOptional<U> flatMap(Function<T, AOptional<U>> function) {
        return new AOptional<>() {
            public U get() {
                T tmp = AOptional.this.get();
                if (Objects.nonNull(tmp) && Objects.nonNull(function)) {
                    return function.apply(tmp).get();
                }
                return null;
            }
        };
    }

    public <U> AOptional<U> map(Function<T, U> function) {
        return new AOptional<>() {
            public U get() {
                T tmp = AOptional.this.get();
                if (Objects.nonNull(tmp) && Objects.nonNull(function)) {
                    return function.apply(tmp);
                }
                return null;
            }
        };
    }

    public <U> U apply(Function<T, U> function) {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(function)) {
            return function.apply(tmp);
        }
        return null;
    }

    public T orElse(T other) {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(other)) {
            return other;
        }
        return null;
    }

    public T orElse(Supplier<T> supplier) {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            return supplier.get();
        }
        return null;
    }

    public T orElseThrow() {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        throw new NoSuchElementException("No value present");
    }

    public <U extends Throwable> T orElseThrow(U throwable) throws U {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(throwable)) {
            throw throwable;
        }
        throw new NullPointerException();
    }

    public <U extends Throwable> T orElseThrow(Supplier<U> supplier) throws U {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            throw supplier.get();
        }
        throw new NullPointerException();
    }

    public boolean isEmpty() {
        return !AOptional.this.isPresent();
    }

    public boolean isPresent() {
        T tmp = AOptional.this.get();
        return Objects.nonNull(tmp);
    }

    public void ifPresent(Consumer<T> consumer) {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(consumer)) {
            consumer.accept(tmp);
        }
    }

    public void ifPresent(Consumer<T> consumer, Runnable runnable) {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp) && Objects.nonNull(consumer)) {
            consumer.accept(tmp);
        }
        if (Objects.nonNull(runnable)) {
            runnable.run();
        }
    }

    public int hashCode() {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp.hashCode();
        }
        return 0;
    }

    public String toString() {
        T tmp = AOptional.this.get();
        if (Objects.nonNull(tmp)) {
            return String.format("AOptional[%s]", tmp);
        }
        return String.format("AOptional[%s]", "empty");
    }

    public boolean equals(Object other) {
        return AOptional.ofNullable(other)
                .filter(AOptional.class::isInstance)
                .map(AOptional.class::cast)
                .filter(AOptional.this::equals)
                .isPresent();
    }

    public <U> boolean equals(AOptional<U> other) {
        return Objects.equals(other.get(), AOptional.this.get());
    }
}