import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  // won't compile - fields cannot use "var"
  final var name = "Jane";

  public static void main(String[] args) {
    // perfectly fine to add final to your var
    final var answer = 42;

    // won't compile - no inferrable type, even though it is definitely assigned
    var valid;

    if (answer == 42) {
      valid = true;
    } else {
      valid = false;
    }

    // null cannot be inferred to a type (inferring to "Object" wouldn't be helpful)
    var book = null;

    // yes, you can name your variable "var"
    var var = "hello";

    // var can be used in Lambda expressions (albeit the usefulness is questionable)
    List<String> someStrings = Arrays.asList("hello", "world");
    var stringLengths = someStrings.stream().map((var s) -> s + ": " + s.length()).toList();

    // won't compile - var is not a generic placeholder for "infer type". Generic inference continues to be expressed as the empty diamond "<>"
    List<String> someMoreStrings = new ArrayList<var>();

    // inferred to "Number & Comparable<? extends Number & Comparable<?>>"
    var inferredTernary = (answer == 42) ? BigInteger.valueOf(42L) : 21.2;
  }

  // var keyword is not allowed for arguments...
  public void doSomething(var parameter) {
    try {
      Integer.parseInt("test");
      // ... nor for catch clauses
    } catch (var numberFormatException) {
      numberFormatException.printStackTrace();
    }
  }
}