import java.util.Objects;
import java.util.function.BiFunction;

@FunctionalInterface
public interface BiPredicate<T, U> {
  Boolean test(T t, U u);

  static <T, U> BiPredicate<T, U> of(BiFunction<T, U, Boolean> bf) {
    return (t, u) -> Objects.requireNonNull(bf).apply(t, u);
  }

  static <T, U> BiPredicate<T, U> or(BiPredicate<T, U> bp1, BiPredicate<T, U> bp2) {
    return (t, u) -> Objects.requireNonNull(bp1).test(t, u) || Objects.requireNonNull(bp2).test(t, u);
  }

  static <T, U> BiPredicate<T, U> xor(BiPredicate<T, U> bp1, BiPredicate<T, U> bp2) {
    return (t, u) -> Objects.requireNonNull(bp1).test(t, u) ^ Objects.requireNonNull(bp2).test(t, u);
  }

  static <T, U> BiPredicate<T, U> and(BiPredicate<T, U> bp1, BiPredicate<T, U> bp2) {
    return (t, u) -> Objects.requireNonNull(bp1).test(t, u) && Objects.requireNonNull(bp2).test(t, u);
  }

  static <T, U> BiPredicate<T, U> not(BiPredicate<T, U> bp) {
    return (t, u) -> !Objects.requireNonNull(bp).test(t, u);
  }

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
}
