package taxonomy;

public abstract sealed class Vertebrate {

  public static sealed class Fish extends Vertebrate {
    public static final class JawlessFish extends Fish {}
    public static final class CartilaginousFish extends Fish {}
    public static final class BonyFish extends Fish {}
  }

  public static final class Amphibian extends Vertebrate {}

  public static final class Reptile extends Vertebrate {}

  public static final class Bird extends Vertebrate {}

  public static non-sealed class Mammal extends Vertebrate {}
}
