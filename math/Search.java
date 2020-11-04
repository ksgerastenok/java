package event.search;

public class Search extends Object {
    public static int binarySearch(int[] array, int value) {
        int i = 0;
        int l = 0;
        int r = array.length - 1;

        while (l <= r) {
            i = (l + r) / 2;
            if (array[i] < value) {
                l = i + 1;
            }
            if (array[i] == value) {
                return (i);
            }
            if (array[i] > value) {
                r = i - 1;
            }
        }

        return (-1);
    }

    public static void main(String[] args) {
        System.out.println(Program.binarySearch(new int[] {2, 3, 4}, 5));

        return;
    }
}
