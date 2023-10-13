package messaging;

public sealed class OrderMessage extends Message permits OrderCreatedMessage, OrderCanceledMessage {

  long orderId;
}
