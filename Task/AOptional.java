package event;

import java.util.*;
import java.util.function.*;

public abstract class AOptional<T> implements Supplier<T> {
    public static <T> AOptional<T> of(T value) {
        return new AOptional<>() {
            public T get() {
                T result = value;
                if (Objects.nonNull(result)) {
                    return result;
                } else {
                    throw new NullPointerException();
                }
            }
        };
    }

    public static <T> AOptional<T> ofNullable(T value) {
        return new AOptional<>() {
            public T get() {
                T result = value;
                if (Objects.nonNull(result)) {
                    return result;
                } else {
                    return null;
                }
            }
        };
    }

    public AOptional<T> or(AOptional<T> other) {
        return new AOptional<>() {
            public T get() {
                T result = AOptional.this.get();
                if (Objects.nonNull(result)) {
                    return result;
                } else {
                    return other.get();
                }
            }
        };
    }

    public AOptional<T> filter(Function<T, Boolean> function) {
        return new AOptional<>() {
            public T get() {
                T result = AOptional.this.get();
                if (Objects.nonNull(result)) {
                    return function.apply(result) ? result : null;
                } else {
                    return null;
                }
            }
        };
    }

    public <U> AOptional<U> flatMap(Function<T, AOptional<U>> function) {
        return new AOptional<>() {
            public U get() {
                T result = AOptional.this.get();
                if (Objects.nonNull(result)) {
                    return function.apply(result).get();
                } else {
                    return null;
                }
            }
        };
    }

    public <U> AOptional<U> map(Function<T, U> function) {
        return new AOptional<>() {
            public U get() {
                T result = AOptional.this.get();
                if (Objects.nonNull(result)) {
                    return function.apply(result);
                } else {
                    return null;
                }
            }
        };
    }

    public T orElse(T other) {
        T result = AOptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            return other;
        }
    }

    public T orElseThrow() {
        T result = AOptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            throw new NullPointerException();
        }
    }

    public <E extends Exception> T orElseThrow(E exception) throws E {
        T result = AOptional.this.get();
        if (Objects.nonNull(result)) {
            return result;
        } else {
            throw exception;
        }
    }

    public boolean isEmpty() {
        T result = AOptional.this.get();
        return Objects.isNull(result);
    }

    public boolean isPresent() {
        T result = AOptional.this.get();
        return Objects.nonNull(result);
    }

    public void ifPresent(Consumer<T> consumer) {
        T result = AOptional.this.get();
        if (Objects.nonNull(result)) {
            consumer.accept(result);
        }
    }

    public void ifPresent(Consumer<T> consumer, Runnable runnable) {
        T result = AOptional.this.get();
        if (Objects.nonNull(result)) {
            consumer.accept(result);
        } else {
            runnable.run();
        }
    }

    public int hashCode() {
        T result = AOptional.this.get();
        if (Objects.nonNull(result)) {
            return result.hashCode();
        } else {
            return 0;
        }
    }

    public String toString() {
        T result = AOptional.this.get();
        if (Objects.nonNull(result)) {
            return String.format("AOptional[%s]", result);
        } else {
            return String.format("AOptional[%s]", "empty");
        }
    }

    public boolean equals(Object other) {
        return AOptional.ofNullable(other)
                .filter(AOptional.class::isInstance)
                .map(AOptional.class::cast)
                .filter(AOptional.this::equals)
                .isPresent();
    }

    private <U> boolean equals(AOptional<U> other) {
        return Objects.equals(other.get(), AOptional.this.get());
    }
}
