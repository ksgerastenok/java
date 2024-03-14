package event;

public class Rational extends Object {
  private long a;
  private long b;

  private Rational(long a, long b) {
    if (b < 0) {
      long gcd = Rational.gcd(Math.abs(a), Math.abs(b));
      this.a = -a / gcd;
      this.b = -b / gcd;
    }
    if (b == 0) {
      throw new ArithmeticException("Division by 0");
    }
    if (b > 0) {
      long gcd = Rational.gcd(Math.abs(a), Math.abs(b));
      this.a = +a / gcd;
      this.b = +b / gcd;
    }
  }

  public Rational add(Rational other) {
    return Rational.of(this.a * other.b + this.b * other.a, this.b * other.b);
  }

  public Rational sub(Rational other) {
    return Rational.of(this.a * other.b - this.b * other.a, this.b * other.b);
  }

  public Rational mul(Rational other) {
    return Rational.of(this.a * other.a, this.b * other.b);
  }

  public Rational div(Rational other) {
    return Rational.of(this.a * other.b, this.b * other.a);
  }

  private boolean equals(Rational other) {
    return ((this.a == other.a) && (this.b == other.b));
  }

  @Override
  public boolean equals(Object other) {
    return Optional.ofNullable(other)
            .filter(Rational.class::isInstance)
            .map(Rational.class::cast)
            .map(this::equals)
            .orElse(Boolean.FALSE);
  }

  @Override
  public int hashCode() {
    return Long.valueOf(31 * this.a + 37 * this.b).intValue();
  }

  @Override
  public String toString() {
    return String.format("%s/%s", this.a, this.b);
  }

  private static long gcd(long a, long b) {
    return (b == 0) ? (a) : (Rational.gcd(b, a % b));
  }

  public static Rational of(long a, long b) {
    return new Rational(a, b);
  }
}
