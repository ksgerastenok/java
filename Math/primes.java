import java.util.*;
import java.util.stream.*;




public class Program extends Object {
    private static List<Integer> getPrimes(int n) {
        for (int i = 1; i != Math.round(Math.sqrt(n)); i += 1) {
            if (n % (i + 1) == 0) {
                return Stream.of(Collections.singletonList(i + 1), getPrimes(n / (i + 1)))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            }
        }

        return(Collections.singletonList(n));
    }

    public static void main(String[] args) {
        System.out.println(getPrimes(171));

    }
}
