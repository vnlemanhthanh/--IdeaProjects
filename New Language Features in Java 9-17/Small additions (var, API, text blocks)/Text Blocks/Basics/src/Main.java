public class Main {

   private static final String JSON = """
       {
         "firstName": "John",  
         "lastName": "Doe",
         "address": {
           "street": "Main Street",
           "city": "New York"
         }
       }
       """;

   public static void main(String[] args) {
      printLines(JSON);
   }

   private static void printLines(String json) {
      // due to how the EDU plugin works we issue separate println
      json.lines().map(Main::showWhitespace).forEach(System.out::println);
   }

   private static String showWhitespace(String input) {
      return input.replace(' ', '·');
   }
}