import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public record Receipt(long receiptId, List<Product> items) {

  public Receipt {
    items = List.copyOf(Objects.requireNonNull(items));
  }

  public BigDecimal total() {
    return items.stream()
        .map(Product::price)
        .map(MonetaryAmount::amount)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
