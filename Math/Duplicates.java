public class Duplicates extends Object {
    // It is guaranteed that ARRAY contains numbers in range 0..N-1
    private static boolean duplicates(int[] array) {
        for (int i = 0; i != array.length; i += 1) {
            while (array[i] != i) {
                int x = array[i];
                array[i] = array[x];
                array[x] = x;
                if (array[i] == array[x]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 1, 6, 4, 0, 5, 3, 7, 2 };

        boolean sort = duplicates(array);
        System.out.println(sort);
        Arrays.stream(array).forEach(System.out::println);
    }
}
