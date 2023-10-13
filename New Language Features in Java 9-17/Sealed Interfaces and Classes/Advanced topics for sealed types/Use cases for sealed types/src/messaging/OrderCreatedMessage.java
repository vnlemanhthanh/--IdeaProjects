package messaging;

import java.util.List;

public final class OrderCreatedMessage extends OrderMessage {

  private List<Product> items;
}
