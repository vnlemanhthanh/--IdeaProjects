public class Main {
   public static void main(String[] args) {
      var point1 = new Point(1, 2);
      var point2 = new Point(2, 3);
      var point3 = new Point(1, 2);

      System.out.println(point1);
      System.out.println(point1.y());

      System.out.println();

      System.out.println(point1.equals(point2)); // false
      System.out.println(point1.equals(point3)); // true - compares components individually

      System.out.println();

      System.out.println(point1.hashCode());
      System.out.println(point3.hashCode());
   }

   /**
    * A point in two-dimensional space.
    *
    * @param x the x coordinate of the Point's location in the Euclidean plane.
    * @param y the y coordinate of the Point's location in the Euclidean plane.
    */
   record Point(int x, int y) {}
}