import java.util.Objects;

public record Product(long inventoryNumber, String name, MonetaryAmount price) {
  public Product {
    Objects.requireNonNull(name);
    Objects.requireNonNull(price);
  }
}
