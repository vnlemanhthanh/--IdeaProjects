public class Main {
   public static void main(String[] args) {
      String answer = switch (Integer.parseInt(args[0])) {
         case 42 -> {
            var arg2 = args[1];
            yield "The answer was " + arg2;
         }

         default -> "wrong answer";
      };

      System.out.println(answer);
   }
}