public class Main {
  public static String toExcel(int x) {
    StringBuilder result = new StringBuilder();

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i = x; i != 0; i = (i - 1) / 26) {
      result.append(alphabet.charAt((i - 1) % 26));
    }

    return result.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(toExcel(27));
  }
}
