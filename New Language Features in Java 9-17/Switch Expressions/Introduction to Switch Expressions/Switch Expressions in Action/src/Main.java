public class Main {

   public static void main(String[] args) {
      System.out.println(getGeographicCoordinateMessage(CompassDirection.NORTH));
   }

   private static String getGeographicCoordinateMessage(CompassDirection direction) {
      String coordinate = switch (direction) {
         case NORTH, SOUTH -> "latitude";
         case EAST, WEST -> "longitude";
      };

      return "The geographical coordinate related to " + direction + " is: " + coordinate;
   }

   enum CompassDirection {
      NORTH, EAST, SOUTH, WEST;
   }
}