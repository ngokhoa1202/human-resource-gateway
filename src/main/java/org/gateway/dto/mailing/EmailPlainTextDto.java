package org.gateway.dto.mailing;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record EmailPlainTextDto(
  @NotBlank @Email String recipient,
  @NotBlank String subject,
  @NotBlank String body
) implements Serializable {

}
