public class Main {

  public static void main(String[] args) {
    System.out.println(getGeographicCoordinateMessage(CompassDirection.NORTH));
  }

  private static String getGeographicCoordinateMessage(CompassDirection direction) {
    String coordinate;

    switch (direction) {
      case NORTH:
      case SOUTH:
        coordinate = "latitude";

      case EAST:
      case WEST:
        coordinate = "longitude";
        break;

      default:
        throw new IllegalArgumentException("Unsupported compass direction: " + direction);
    }

    return "The geographical coordinate related to " + direction + " is: " + coordinate;
  }

  enum CompassDirection {
    NORTH, EAST, SOUTH, WEST;
  }
}