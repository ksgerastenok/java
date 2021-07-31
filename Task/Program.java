package test;

public class Program {
    public static String deleteSpaces(String source, char delimiter) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i != source.length(); i += 1) {
            if (source.charAt(i) != delimiter) {
                result.append(source.charAt(i));
                if ((i + 1 == source.length()) || (source.charAt(i + 1) == delimiter)) {
                    result.append(delimiter);
                }
            }
        }
        if (result.length() != 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(deleteSpaces("___On__my___home_world___", '_'));
    }
}
