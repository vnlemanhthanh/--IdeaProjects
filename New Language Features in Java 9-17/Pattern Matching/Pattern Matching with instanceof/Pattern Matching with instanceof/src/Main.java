public class Main {

  public static void main(String[] args) {
    Object maybeAString = "definitely a string";

    if (maybeAString instanceof String s) {
      System.out.println("It's definitely a String of length " + s.length());
    } else {
      // just a regular object here, can't access "s"
    }

    if (maybeAString instanceof String s && s.length() > 5) {
      System.out.println("It has more than 5 characters");
    }

    // pattern variables can be assigned to, so if you have a "always final" codebase, you may want to declare them final as well
    if (maybeAString instanceof final Number n) {

    }
  }
}