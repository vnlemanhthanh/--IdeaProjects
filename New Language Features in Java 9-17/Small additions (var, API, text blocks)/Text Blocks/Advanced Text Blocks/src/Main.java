public class Main {

   private static final String SIGNIFICANT_WHITESPACE = """
       Make the white space significant:
       each    \s
       of      \s
       these   \s
       lines   \s
       is      \s
       equally \s
       long    \s
       """;

   private static final String DO_NOT_ADD_NEW_LINES = """
       The backslash ensures \
       that the whole String \
       ends up on a single line.\
       """;

   public static void main(String[] args) {
      System.out.println("*** SIGNIFICANT_WHITESPACE ***");
      printLines(SIGNIFICANT_WHITESPACE);

      System.out.println();

      System.out.println("*** DO_NOT_ADD_NEW_LINES ***");
      printLines(DO_NOT_ADD_NEW_LINES);
   }

   private static void printLines(String json) {
      // due to how the EDU plugin works we issue separate println
      json.lines().map(Main::showWhitespace).forEach(System.out::println);
   }

   private static String showWhitespace(String input) {
      return input.replace(' ', '·');
   }
}