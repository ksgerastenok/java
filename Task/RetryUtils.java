import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

public interface RetryUtils {
  static void retry(
      int count,
      Duration duration,
      Collection<Class<? extends Exception>> classes,
      Runnable method
  ) {
    for (int i = count; i != 0; i -= 1) {
      try {
        try {
          System.out.println("Trying execution, rest count: " + i);
          Optional
              .ofNullable(method)
              .orElseThrow()
              .run();
          System.out.println("Success");
          return;
        } catch (Exception ex) {
          System.out.print("Unsuccess. ");
          if (i == 1) {
            System.out.println("Limit exceed. Rethrowing.");
            throw ex;
          } else if (
              Optional
                  .ofNullable(classes)
                  .orElse(List.of())
                  .stream()
                  .noneMatch(ex.getClass()::equals)
          ) {
            System.out.println("Unknown exception. Rethrowing.");
            throw ex;
          } else {
            System.out.println("Suppressed exception. Sleeping.");
            Thread.sleep(
                Optional
                    .ofNullable(duration)
                    .orElse(Duration.ZERO)
                    .multipliedBy(count - i + 1)
            );
          }
        }
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    }
    throw new RuntimeException("Something went wrong.");
  }

  static <T> T retry(
      int count,
      Duration duration,
      Collection<Class<? extends Exception>> classes,
      Callable<T> method
  ) {
    for (int i = count; i != 0; i -= 1) {
      try {
        try {
          System.out.println("Trying execution, rest count: " + i);
          T result = Optional
              .ofNullable(method)
              .orElseThrow()
              .call();
          System.out.println("Success");
          return result;
        } catch (Exception ex) {
          System.out.print("Unsuccess. ");
          if (i == 1) {
            System.out.println("Limit exceed. Rethrowing.");
            throw ex;
          } else if (
              Optional
                  .ofNullable(classes)
                  .orElse(List.of())
                  .stream()
                  .noneMatch(ex.getClass()::equals)
          ) {
            System.out.println("Unknown exception. Rethrowing.");
            throw ex;
          } else {
            System.out.println("Suppressed exception. Sleeping.");
            Thread.sleep(
                Optional
                    .ofNullable(duration)
                    .orElse(Duration.ZERO)
                    .multipliedBy(count - i + 1)
            );
          }
        }
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    }
    throw new RuntimeException("Something went wrong.");
  }
}
