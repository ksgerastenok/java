package task;

import java.util.*;

public class Program {
    private static final Random random = new Random();

    private static void test(final List<Integer> data) {
        String standard = Serializer.STD.convert(data);
        String compact = Serializer.SMART.convert(data);
        System.out.printf("Source string: %s", standard);
        System.out.println();
        System.out.printf("Compact string: %s", compact);
        System.out.println();
        System.out.printf("Ratio: %.2f", 100.0 * compact.length() / standard.length());
        System.out.println();
        System.out.println();
    }

    private static void testBetween(final int min, final int max, final int count) {
        System.out.printf("Test numbers (%d-%d) at count %d.", min, max, count);
        System.out.println();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i != count; i += 1) {
            result.add(random.nextInt(max - min + 1) + min);
        }
        test(result);
    }

    private static void testCustom(final int count) {
        System.out.printf("Test all numbers (1-300) at count %d for each.", count);
        System.out.println();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i != 300; i += 1) {
            for (int k = 0; k != count; k += 1) {
                result.add(i + 1);
            }
        }
        test(result);
    }

    public static void main(String[] args) {
        testBetween(1, 9, 50);
        testBetween(1, 9, 100);
        testBetween(1, 9, 500);
        testBetween(1, 300, 1000);
        testBetween(1, 9, 1000);
        testBetween(10, 99, 1000);
        testBetween(100, 300, 1000);
        testCustom(3);
    }
}
