public class Main {

  public static void main(String[] args) {
    var stringWithUnicodeWhitespace = "Followed by a thin space\u2009";
    var anotherString = "and another string";

    System.out.println(stringWithUnicodeWhitespace.trim() + anotherString);
    System.out.println(stringWithUnicodeWhitespace.strip() + anotherString);

    System.out.println();

    var aroundWhitespace = "   hello   ";

    System.out.println(aroundWhitespace.stripLeading() + "!");
    System.out.println(aroundWhitespace.stripTrailing() + "!");

    System.out.println();

    System.out.println("A number: %f".formatted(0.5));

    System.out.println();

    System.out.println("Alan! ".repeat(10));

    System.out.println();

    System.out.print("isBlank(): ");
    System.out.println("       ".isBlank());

    var textBlock = """
        Hello
        luck
        wall
        """;
    System.out.print("Number of Ls per line: ");
    System.out.println(textBlock.lines().mapToInt(Main::countLs).boxed().toList());
  }

  private static int countLs(String aString) {
    return Math.toIntExact(aString.chars().filter(c -> 'l' == c).count());
  }
}