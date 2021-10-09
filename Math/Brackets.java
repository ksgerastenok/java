public class Brackets extends Object {
    public static Set<String> genrec(int n) {
        Set<String> result = new TreeSet<>();

        if (n == 0) {
            result.add("");
        }
        for (int i = 1; i != n + 1; i += 1) {
            for (String x : genrec(n - i)) {
                for (String y : genrec(i - 1)) {
                    result.add("(" + ")" + x + y);
                    result.add("(" + x + ")" + y);
                    result.add(x + "(" + ")" + y);
                    result.add(x + "(" + y + ")");
                    result.add(x + y + "(" + ")");
                }
            }
        }

        return result;
    }

    public static Set<String> geniter(int n) {
        List<Set<String>> result = new ArrayList<>();

        for (int k = 0; k != n + 1; k += 1) {
            result.add(new TreeSet<>());
            if (k == 0) {
                result.get(k).add("");
            }
            for (int i = 1; i != k + 1; i += 1) {
                for (String x : result.get(k - i)) {
                    for (String y : result.get(i - 1)) {
                        result.get(k).add("(" + ")" + x + y);
                        result.get(k).add("(" + x + ")" + y);
                        result.get(k).add(x + "(" + ")" + y);
                        result.get(k).add(x + "(" + y + ")");
                        result.get(k).add(x + y + "(" + ")");
                    }
                }
            }
        }

        return result.get(n);
    }

    public static void main(String[] args) {
        geniter(5).forEach(System.out::println);
    }
}
