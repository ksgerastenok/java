package event;

public class Rational extends Object {
    private final long a;
    private final long b;

    private Rational(long a, long b) {
        if (b < 0) {
            this.a = -a;
            this.b = -b;
        } else {
            this.a = +a;
            this.b = +b;
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

    public String toString() {
        return String.format("%s/%s", this.a, this.b);
    }

    public boolean equals(Object other) {
        return Optional.ofNullable(other)
                .filter(Rational.class::isInstance)
                .map(Rational.class::cast)
                .map(this::equals)
                .orElse(Boolean.FALSE);
    }

    public int hashCode() {
        return Long.valueOf(31 * this.a + 37 * this.b).intValue();
    }

    private boolean equals(Rational other) {
        return ((this.a == other.a) && (this.b == other.b));
    }

    public static Rational of(long a, long b) {
        long gcd = Rational.gcd(a, b);
        return new Rational(a / gcd, b / gcd);
    }

    private static long gcd(long a, long b) {
        return (b == 0)
            ? a
            : Rational.gcd(b, a % b);
    }
}
