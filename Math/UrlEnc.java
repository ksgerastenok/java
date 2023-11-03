package event;


public class Program extends Object {
    public static void replace(char[] data) {
        int count = 0;

        for (int i = 0; i != data.length; i += 1) {
            if (data[i] == ' ') {
                count += 1;
            }
        }

        for (int i = data.length; i != 0; i -= 1) {
            if (data[i - 1 - count * 2] == ' ') {
                data[i - 1 - count * 2] = '%';
                data[i - count * 2] = '2';
                data[i + 1 - count * 2] = '0';
                count -= 1;
            }

            data[i - 1] = data[i - 1 - count * 2];
        }

        return;
    }

    public static void print(char[] data) {
        for (int i = 0; i != data.length; i += 1) {
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
