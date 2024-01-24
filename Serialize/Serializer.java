package task;

import java.util.*;
import java.util.function.*;

public enum Serializer {
    ARRAY(Serializer::array, Serializer::array),
    COUNT(Serializer::count, Serializer::count),
    SMART(Serializer::smart, Serializer::smart),
    STD(Serializer::std, Serializer::std);

    private final Function<List<Integer>, String> from;
    private final Function<String, List<Integer>> to;

    Serializer(Function<List<Integer>, String> from, Function<String, List<Integer>> to) {
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

    private static String array(final List<Integer> data) {
        final StringJoiner result = new StringJoiner(",");

        final int[] counter = new int[300];
        for (int value : data) {
            counter[value - 1] += 1;
        }
        for (int i = 0; i != counter.length; i += 1) {
            result.add(radix36(counter[i]));
        }

        return result.toString();
    }

    private static List<Integer> array(final String data) {
        final List<Integer> result = new ArrayList<>();

        final String[] numbers = data.split(",");
        for (int i = 0; i != numbers.length; i += 1) {
            final int value = i + 1;
            final int count = radix36(numbers[i]);
            for (int k = 0; k != count; k += 1) {
                result.add(value);
            }
        }

        return result;
    }

    private static String count(final List<Integer> data) {
        final StringJoiner result = new StringJoiner(",");

        final Map<Integer, Integer> counter = new HashMap<>();
        for (int value : data) {
            counter.put(value, counter.getOrDefault(value, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            result.add(String.format("%s:%s", radix36(entry.getKey()), radix36(entry.getValue())));
        }

        return result.toString();
    }

    private static List<Integer> count(final String data) {
        final List<Integer> result = new ArrayList<>();

        final String[] numbers = data.split(",");
        for (int i = 0; i != numbers.length; i += 1) {
            final int value = radix36(numbers[i].split(":")[0]);
            final int count = radix36(numbers[i].split(":")[1]);
            for (int k = 0; k != count; k += 1) {
                result.add(value);
            }
        }

        return result;
    }

    private static String smart(final List<Integer> data) {
        return (data.stream().distinct().count() <= 120) ? count(data) : array(data);
    }

    private static List<Integer> smart(final String data) {
        return (data.contains(":")) ? count(data) : array(data);
    }

    private static String std(final List<Integer> data) {
        final StringJoiner result = new StringJoiner(",");

        for (int value : data) {
            result.add(String.valueOf(value));
        }

        return result.toString();
    }

    private static List<Integer> std(final String data) {
        final List<Integer> result = new ArrayList<>();

        final String[] numbers = data.split(",");
        for (int i = 0; i != numbers.length; i += 1) {
            result.add(Integer.parseInt(numbers[i]));
        }

        return result;
    }

    public String convert(final List<Integer> data) {
        return this.from.apply(data);
    }

    public List<Integer> convert(final String data) {
        return this.to.apply(data);
    }
}
