import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public record MonetaryAmount(Currency currency, BigDecimal amount) {
  public MonetaryAmount {
    Objects.requireNonNull(currency);
    Objects.requireNonNull(amount);

    if (amount.signum() < 0) {
      throw new IllegalArgumentException("Negative amount " + amount + " not allowed");
    }
  }

  /**
   * Constructs a {@link MonetaryAmount} using the currency's smallest unit (cents, pennies, etc.).
   * It is assumed that 100 pieces of the smaller unit make up 1 piece of the main unit.
   *
   * @param currency currency for the amount
   * @param amountOfSmallestUnit how much of the smallest unit this amount represents
   */
  public MonetaryAmount(Currency currency, long amountOfSmallestUnit) {
    this(currency, BigDecimal.valueOf(amountOfSmallestUnit, 2));
  }
}
