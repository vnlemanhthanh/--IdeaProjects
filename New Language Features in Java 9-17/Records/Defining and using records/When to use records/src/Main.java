import java.util.Currency;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Currency euro = Currency.getInstance("EUR");

    Product bread = new Product(1L, "Bread", new MonetaryAmount(euro, 199));
    Product onions = new Product(2L, "Onions", new MonetaryAmount(euro, 179));

    var receipt = new Receipt(1L, List.of(bread, bread, onions));

    System.out.println(receipt);
    System.out.println("Total: " + receipt.total());
  }
}