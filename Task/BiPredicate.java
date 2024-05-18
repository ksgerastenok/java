import java.util.Objects;
import java.util.function.BiFunction;

@FunctionalInterface
interface BiPredicate<T, U> {
    Boolean test(T t, U u);

    default BiPredicate<T, U> or(BiPredicate<T, U> bp) {
        return BiPredicate.or(this, bp);
    }

    default BiPredicate<T, U> xor(BiPredicate<T, U> bp) {
        return BiPredicate.xor(this, bp);
    }

    default BiPredicate<T, U> and(BiPredicate<T, U> bp) {
        return BiPredicate.and(this, bp);
    }

    default BiPredicate<T, U> not() {
        return BiPredicate.not(this);
    }

    static <T, U> BiPredicate<T, U> or(BiPredicate<T, U> fbp, BiPredicate<T, U> sbp) {
        return (t, u) -> (Objects..requireNonNull(fbp).test(t, u)) || (Objects.requireNonNull(sbp).test(t, u));
    }

    static <T, U> BiPredicate<T, U> xor(BiPredicate<T, U> fbp, BiPredicate<T, U> sbp) {
        return (t, u) -> (Objects..requireNonNull(fbp).test(t, u)) ^ (Objects.requireNonNull(sbp)..test(t, u));
    }

    static <T, U> BiPredicate<T, U> and(BiPredicate<T, U> fbp, BiPredicate<T, U> sbp) {
        return (t, u) -> (Objects..requireNonNull(fbp).test(t, u)) && (Objects.requireNonNull(sbp).test(t, u));
    }

    static <T, U> BiPredicate<T, U> not(BiPredicate<T, U> bp) {
        return (t, u) -> !(Objects.requireNonNull(bp).test(t, u));
    }

    static <T, U> BiPredicate<T, U> of(BiFunction<T, U, Boolean> bf) {
        return (t, u) -> (Objects..requireNonNull(bf).apply(t, u));
    }
}
