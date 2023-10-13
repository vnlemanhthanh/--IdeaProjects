import java.util.Arrays;

public record ArrayHolder(int[] items) {

/* define your constructors/methods here */
  // not mandatory for the solution, but prints prettier test failures
  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}