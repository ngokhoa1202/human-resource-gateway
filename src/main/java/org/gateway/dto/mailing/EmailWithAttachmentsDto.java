package org.gateway.dto.mailing;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.FormParam;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.util.List;

public record EmailWithAttachmentsDto(
  @FormParam(value = "recipient") @Email String recipient,
  @FormParam(value = "subject") @NotBlank String subject,
  @FormParam(value = "body") @NotNull String body,
  @FormParam(value = "attachments") List<FileUpload> attachments
) {
}
