package event.math;

public class Program extends Object {
    public static double pow(double x, int n) {
        if (n == 0) {
            return (1);
        } else {
            if (n % 2 == -1) {
                return (Program.pow(x, n / 2) * Program.pow(x, n / 2) / x);
            }
            if (n % 2 == 0) {
                return (Program.pow(x, n / 2) * Program.pow(x, n / 2));
            }
            if (n % 2 == +1) {
                return (Program.pow(x, n / 2) * Program.pow(x, n / 2) * x);
            }
        }

        return (0);
    }

    public static int divide(int dividend, int divisor) {
        long result, div, dis, n, m;

        div = (dividend < 0) ? ((long) (~dividend)) + 1 : ((long) (dividend));
        dis = (divisor < 0) ? ((long) (~divisor)) + 1 : ((long) (divisor));

        n = 0;
        for (long i = div; (i != 0); i >>= 1) {
            n += 1;
        }
        m = 0;
        for (long i = dis; (i != 0); i >>= 1) {
            m += 1;
        }

        result = 0;
        for (long i = n - m + 1; i != 0; i -= 1) {
            if ((div >= (dis << (i - 1)))) {
                div -= (dis << (i - 1));
                result += (1L << (i - 1));
            }
        }

        result = ((((dividend > 0) && (divisor < 0)) || ((dividend < 0) && (divisor > 0))) ? (~result) + 1 : (result));

        return ((int) (result == 2147483648L ? result - 1 : result));
    }

    public static int gcd(int a, int b) {
        return ((b == 0) ? (a) : (Program.gcd(b, a % b)));
    }

    public static int lcm(int a, int b) {
        return ((a * b) / Program.gcd(a, b));
    }

    public static void main(String[] args) {
        return;
    }
}
