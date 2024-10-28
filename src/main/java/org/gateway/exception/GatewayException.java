package org.gateway.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gateway.exception.mapper.ErrorResponseBody;

import java.time.LocalDateTime;

public class GatewayException extends WebApplicationException {
  
  public GatewayException(final String fieldName, final String message, final Response.Status status) {

    super(Response.status(status)
      .entity(new ErrorResponseBody(status.getStatusCode(), fieldName, message, LocalDateTime.now()))
      .type(MediaType.APPLICATION_JSON_TYPE)
      .build()
    );
  }
}
