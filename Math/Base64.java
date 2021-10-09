public class Base64 extends Object {
    private static byte[] toBase64Byte(byte[] source) {
        byte[] result = new byte[(int) Math.ceil(1.0 * source.length * 8 / 6)];

        for (int i = 0; i != source.length * 8; i += 1) {
            if (((source[i / 8] >> (7 - i % 8)) & 1) == 1) {
                result[i / 6] |= (byte) (1 << (5 - i % 6));
            }
        }

        return result;
    }

    private static byte[] toBase64Symbol(byte[] source) {
        byte[] result = new byte[source.length];

        String symbol = String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        for (int i = 0; i != source.length; i += 1) {
            result[i] = (byte) symbol.codePointAt(source[i]);
        }

        return result;
    }

    public static byte[] toBase64(byte[] source) {
        return toBase64Symbol(toBase64Byte(source));
    }

    private static byte[] fromBase64Byte(byte[] source) {
        byte[] result = new byte[(int) Math.floor(1.0 * source.length * 6 / 8)];

        for (int i = 0; i != source.length * 6; i += 1) {
            if (((source[i / 6] >> (5 - i % 6)) & 1) == 1) {
                result[i / 8] |= (byte) (1 << (7 - i % 8));
            }
        }

        return result;
    }

    private static byte[] fromBase64Symbol(byte[] source) {
        byte[] result = new byte[source.length];

        String symbol = String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        for (int i = 0; i != source.length; i += 1) {
            result[i] = (byte) symbol.indexOf(source[i]);
        }

        return result;
    }

    public static byte[] fromBase64(byte[] source) {
        return fromBase64Byte(fromBase64Symbol(source));
    }

    public static void main(String[] args) {
        System.out.println(toBase64(String.valueOf("Hello World").getBytes()));
    }
}