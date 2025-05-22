interface Tuple<T extends Tuple<T>> {
  record Twice<V, N extends Tuple<N>>(V value, N next) implements Tuple<Twice<V, N>> {
  }

  record Once<V>(V value) implements Tuple<Once<V>> {
  }
}

public class Main {
  public static void main(String[] args) throws Throwable {
    Tuple.Twice<Integer, Tuple.Twice<Double, Tuple.Once<String>>> x = new Tuple.Twice<>(
        5, new Tuple.Twice<>(
            7.0, new Tuple.Once<>("Hello World")
        )
    );
    System.out.println(x.next().next().value());
  }
}
