package messaging;

import java.time.Instant;
import java.util.UUID;

public abstract sealed class Message permits OrderMessage, AccountCreatedMessage {

  private UUID messageId;

  private Instant createdAt;
}
