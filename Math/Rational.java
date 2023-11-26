package event;

public class Rational extends Object {
    private final long a;
    private final long b;

    private Rational(long a, long b) {
        long gcd = Rational.gcd(a, b);
        this.a = a / gcd;
        this.b = b / gcd;
    }

    public Rational add(Rational other) {
        long gcd = Rational.gcd(this.b, other.b);
        return Rational.of(this.a * (other.b / gcd) + other.a * (this.b / gcd), gcd * (this.b / gcd) * (other.b / gcd));
    }

    public Rational sub(Rational other) {
        long gcd = Rational.gcd(this.b, other.b);
        return Rational.of(this.a * (other.b / gcd) - other.a * (this.b / gcd), gcd * (this.b / gcd) * (other.b / gcd));
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
        return Long.valueOf(31 * this.a + 35 * this.b).intValue();
    }

    private boolean equals(Rational other) {
        return ((this.a == other.a) && (this.b == other.b));
    }

    public static Rational of(long a, long b) {
        return new Rational(a, b);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
