import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Predicate<T> {
  Boolean test(T t);

  static <T> Predicate<T> of(Function<T, Boolean> f) {
    return (t) -> Objects.requireNonNull(f).apply(t);
  }

  static <T> Predicate<T> or(Predicate<T> p1, Predicate<T> p2) {
    return (t) -> Objects.requireNonNull(p1).test(t) || Objects.requireNonNull(p2).test(t);
  }

  static <T> Predicate<T> xor(Predicate<T> p1, Predicate<T> p2) {
    return (t) -> Objects.requireNonNull(p1).test(t) ^ Objects.requireNonNull(p2).test(t);
  }

  static <T> Predicate<T> and(Predicate<T> p1, Predicate<T> p2) {
    return (t) -> Objects.requireNonNull(p1).test(t) && Objects.requireNonNull(p2).test(t);
  }

  static <T> Predicate<T> not(Predicate<T> p) {
    return (t) -> !Objects.requireNonNull(p).test(t);
  }

  default Predicate<T> or(Predicate<T> p) {
    return Predicate.or(this, p);
  }

  default Predicate<T> xor(Predicate<T> p) {
    return Predicate.xor(this, p);
  }

  default Predicate<T> and(Predicate<T> p) {
    return Predicate.and(this, p);
  }

  default Predicate<T> not() {
    return Predicate.not(this);
  }
}
