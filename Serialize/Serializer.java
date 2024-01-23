package task;


import java.util.*;
import java.util.function.*;

public enum Serializer {
    ARRAY(Serializer::array, Serializer::array),
    COUNT(Serializer::count, Serializer::count),
    SMART(Serializer::smart, Serializer::smart),
    STD(Serializer::std, Serializer::std);

    private final Function<Map<Integer, Integer>, String> from;
    private final Function<String, Map<Integer, Integer>> to;

    Serializer(Function<Map<Integer, Integer>, String> from, Function<String, Map<Integer, Integer>> to) {
        this.from = from;
        this.to = to;
    }

    private static String radix36(final int data) {
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = (data == 0) ? new StringBuilder("0") : new StringBuilder();

        for (int i = data; i != 0; i /= 36) {
            result.append(alphabet.charAt(i % 36));
        }

        return result.reverse().toString();
    }

    private static int radix36(final String data) {
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int result = 0;

        for (int i = 0; i != data.length(); i += 1) {
            result *= 36;
            result += alphabet.indexOf(data.charAt(i));
        }

        return result;
    }

    private static Map<Integer, Integer> counter(final List<Integer> data) {
        final Map<Integer, Integer> result = new HashMap<>();

        for (Integer value : data) {
            result.put(value, result.getOrDefault(value, 0) + 1);
        }

        return result;
    }

    private static List<Integer> counter(final Map<Integer, Integer> data) {
        final List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            for (int i = 0; i != entry.getValue(); i += 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    private static String array(final Map<Integer, Integer> data) {
        final StringJoiner result = new StringJoiner(",");

        final int[] linear = new int[300];
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            linear[entry.getKey() - 1] = entry.getValue();
        }
        for (int i = 0; i != linear.length; i += 1) {
            result.add(radix36(linear[i]));
        }

        return result.toString();
    }

    private static Map<Integer, Integer> array(final String data) {
        final Map<Integer, Integer> result = new HashMap<>();

        final String[] numbers = data.split(",");
        for (int i = 0; i != numbers.length; i += 1) {
            result.put(i + 1, radix36(numbers[i]));
        }

        return result;
    }

    private static String count(final Map<Integer, Integer> data) {
        final StringJoiner result = new StringJoiner(",");

        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            final String[] values = new String[] { radix36(entry.getKey()), radix36(entry.getValue()) };
            result.add(String.format("%s:%s", values[0], values[1]));
        }

        return result.toString();
    }

    private static Map<Integer, Integer> count(final String data) {
        final Map<Integer, Integer> result = new HashMap<>();

        final String[] numbers = data.split(",");
        for (int i = 0; i != numbers.length; i += 1) {
            final String[] values = numbers[i].split(":");
            result.put(radix36(values[0]), radix36(values[1]));
        }

        return result;
    }

    private static String smart(final Map<Integer, Integer> data) {
        if (data.keySet().size() <= 120) {
            return count(data);
        } else {
            return array(data);
        }
    }

    private static Map<Integer, Integer> smart(final String data) {
        if (data.contains(":")) {
            return count(data);
        } else {
            return array(data);
        }
    }

    private static String std(final Map<Integer, Integer> data) {
        final StringJoiner result = new StringJoiner(",");

        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            for (int i = 0; i != entry.getValue(); i += 1) {
                String value = String.valueOf(entry.getKey());
                result.add(value);
            }
        }

        return result.toString();
    }

    private static Map<Integer, Integer> std(final String data) {
        final Map<Integer, Integer> result = new HashMap<>();

        final String[] numbers = data.split(",");
        for (int i = 0; i != numbers.length; i += 1) {
            Integer value = Integer.parseInt(numbers[i]);
            result.put(value, result.getOrDefault(value, 0) + 1);
        }

        return result;
    }

    public String convert(final List<Integer> data) {
        return this.from.apply(counter(data));
    }

    public List<Integer> convert(final String data) {
        return counter(this.to.apply(data));
    }
}
