import java.util.*;
import java.util.stream.*;

public class Program extends Object {
    private static List<Integer> sums1(Integer n, Map<Integer, Integer> values) {

        if (n == 0) {
            return (Collections.singletonList(n));
        } else {
            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry: new TreeMap<>(values).descendingMap().subMap(n, 0).entrySet()) {
                for (Integer i = 0; !i.equals(entry.getValue()); i += 1) {
                    result.addAll(
                        sums1(
                            n - entry.getKey(),
                            values.entrySet().stream().collect(
                                Collectors.toMap(
                                    s -> s.getKey().equals(entry.getKey()) ? s.getKey() - 0 : s.getKey(),
                                    s -> s.getKey().equals(entry.getKey()) ? s.getValue() - 1 : s.getValue()
                                )
                            )
                        )
                    );
                    if (!result.isEmpty()) {
                        result.addAll(Collections.nCopies(1, entry.getKey()));
                        return (result);
                    }
                }
            }
        }

        return (Collections.emptyList());
    }

    private static List<Integer> sums2(Integer n, Map<Integer, Integer> values) {
        if (n == 0) {
            return (Collections.singletonList(n));
        } else {
            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry: new TreeMap<>(values).descendingMap().subMap(n, 0).entrySet()) {
                Integer x = Math.min(entry.getValue(), (n - (n % entry.getKey())) / entry.getKey());
                if (!x.equals(0)) {
                    result.addAll(
                        sums2(
                            n - x * entry.getKey(),
                            values.entrySet().stream().collect(
                                Collectors.toMap(
                                    s -> s.getKey().equals(entry.getKey()) ? s.getKey() - 0 : s.getKey(),
                                    s -> s.getKey().equals(entry.getKey()) ? s.getValue() - x : s.getValue()
                                )
                            )
                        )
                    );
                    if (!result.isEmpty()) {
                        result.addAll(Collections.nCopies(x, entry.getKey()));
                        return (result);
                    }
                }
            }
        }

        return (Collections.emptyList());
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 3);
        map.put(1, 1);
        map.put(3, 7);
        map.put(4, 7);
        map.put(5, 9);
        map.put(7, 5);
        map.put(10, 5);
        map.put(50, 4);
        System.out.println(sums1(307, map));
        System.out.println(sums2(307, map));
        System.out.println(sums1(307, map).equals(sums2(307, map)));
    }
}
