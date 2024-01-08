package event;


public class Program extends Object {
    public static int replace(char[] data, int length) {
        int count = 0;
        for (int i = length; i != 0; i -= 1) {
            if (data[i - 1] == ' ') {
                count += 1;
            }
        }

        int result = length + count * 2;
        for (int i = length; i != 0; i -= 1) {
            if (data[i - 1] == ' ') {
                data[i - 1] = '%';
                data[i] = '2';
                data[i + 1] = '0';
                count -= 1;
                data[i - 1 + count * 2] = '%';
                data[i + count * 2] = '2';
                data[i + 1 + count * 2] = '0';
            }
            data[i - 1 + count * 2] = data[i - 1];
        }

        return result;
    }

    public static void print(char[] data, int length) {
        for (int i = 0; i != length; i += 1) {
            System.out.print(data[i]);
        }
        System.out.println();

        return;
    }

    public static void main(String[] args) {
        char[] data = new char[] { 'm', ' ', 'y', ' ', 'd', ' ', 'a', ' ', 't', 'a', 0, 0, 0, 0, 0, 0, 0, 0 };

        replace(data);
        print(data);

        return;
    }
}
