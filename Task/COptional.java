final class COptional<T> {
    private Supplier<T> value;

    private COptional(Supplier<T> value) {
        COptional.this.value = value;
    }

    private T get() {
        return COptional.this.value.get();
    }

    public static <T> COptional<T> of(Supplier<T> value) {
        return new COptional<>(() -> {
            T tmp = value.get();
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            throw new NullPointerException();
        });
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

    public static <T> COptional<T> ofNullable(Supplier<T> value) {
        return new COptional<>(() -> {
            T tmp = value.get();
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            return null;
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
            T tmp = COptional.this.get();
            if (Objects.nonNull(tmp)) {
                return tmp;
            }
            if (Objects.nonNull(other)) {
                return other.get();
            }
            return null;
        });
    }

    public COptional<T> or(Supplier<COptional<T>> supplier) {
        return new COptional<>(() -> {
            if (Objects.nonNull(supplier)) {
                return COptional.this.or(supplier.get()).get();
            }
            return null;
        });
    }

    public COptional<T> filter(Function<T, Boolean> function) {
        return new COptional<>(() -> {
            if (Objects.nonNull(function)) {
                T tmp = COptional.this.get();
                if (Objects.nonNull(tmp)) {
                    if (function.apply(tmp)) {
                        return tmp;
                    }
                }
            }
            return null;
        });
    }

    public <U> COptional<U> flatMap(Function<T, COptional<U>> function) {
        return new COptional<>(() -> {
            if (Objects.nonNull(function)) {
                return COptional.this.map(function).map(COptional::get).get();
            }
            return null;
        });
    }

    public <U> COptional<U> map(Function<T, U> function) {
        return new COptional<>(() -> {
            if (Objects.nonNull(function)) {
                T tmp = COptional.this.get();
                if (Objects.nonNull(tmp)) {
                    return function.apply(tmp);
                }
            }
            return null;
        });
    }

    public T orElse(T other) {
        T tmp = COptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(other)) {
            return other;
        }
        return null;
    }

    public T orElse(Supplier<T> supplier) {
        T tmp = COptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            return supplier.get();
        }
        return null;
    }

    public T orElseThrow() {
        T tmp = COptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        throw new NullPointerException();
    }

    public <U extends Throwable> T orElseThrow(U throwable) throws U {
        T tmp = COptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(throwable)) {
            throw throwable;
        }
        throw new NullPointerException();
    }

    public <U extends Throwable> T orElseThrow(Supplier<U> supplier) throws U {
        T tmp = COptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp;
        }
        if (Objects.nonNull(supplier)) {
            throw supplier.get();
        }
        throw new NullPointerException();
    }

    public boolean isEmpty() {
        T tmp = COptional.this.get();
        return Objects.isNull(tmp);
    }

    public boolean isPresent() {
        T tmp = COptional.this.get();
        return Objects.nonNull(tmp);
    }

    public void ifPresent(Consumer<T> consumer) {
        if (Objects.nonNull(consumer)) {
            T tmp = COptional.this.get();
            if (Objects.nonNull(tmp)) {
                consumer.accept(tmp);
            }
        }
    }

    public void ifPresent(Consumer<T> consumer, Runnable runnable) {
        if (Objects.nonNull(consumer)) {
            T tmp = COptional.this.get();
            if (Objects.nonNull(tmp)) {
                consumer.accept(tmp);
            } else {
                if (Objects.nonNull(runnable)) {
                    runnable.run();
                }
            }
        }
    }

    public int hashCode() {
        T tmp = COptional.this.get();
        if (Objects.nonNull(tmp)) {
            return tmp.hashCode();
        }
        return 0;
    }

    public String toString() {
        T tmp = COptional.this.get();
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
        return Objects.equals(other.get(), COptional.this.get());
    }
}
