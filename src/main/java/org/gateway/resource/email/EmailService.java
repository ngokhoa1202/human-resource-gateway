package org.gateway.resource.email;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.gateway.dto.mailing.EmailPlainTextDto;

import java.util.UUID;

public class EmailService {

  @Channel("emailPlainText")
  protected Emitter<EmailPlainTextDto> userIdEmitter;
}
