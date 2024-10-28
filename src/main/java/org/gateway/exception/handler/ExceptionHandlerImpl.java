package org.gateway.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.grpc.StatusRuntimeException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.gateway.exception.GatewayException;

@ApplicationScoped
public class ExceptionHandlerImpl implements ExceptionHandler {

  @Override
  public GatewayException convert(StatusRuntimeException statusRuntimeException) {
    try {
      JsonNode node = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .reader().readTree(this.getJsonSubStr(statusRuntimeException.getMessage()));
      Response.Status status = this.toHttpStatus(statusRuntimeException.getStatus());
      return new GatewayException(
        node.get("field").asText(),
        node.get("message").asText(),
        status
      );
    } catch (JsonProcessingException e) {
      return new GatewayException(
        "undefined",
        e.getMessage(),
        Response.Status.INTERNAL_SERVER_ERROR
      );
    }
  }

  public Response.Status toHttpStatus(io.grpc.Status status) {
    if (status.equals(io.grpc.Status.NOT_FOUND)) {
      return Response.Status.NOT_FOUND;
    }
    if (status.equals(io.grpc.Status.PERMISSION_DENIED)) {
      return Response.Status.UNAUTHORIZED;
    }
    if (status.equals(io.grpc.Status.ALREADY_EXISTS)) {
      return Response.Status.CONFLICT;
    }

    return Response.Status.BAD_REQUEST;
  }

  private String getJsonSubStr(String message) {
    return message.substring(message.indexOf("{"));
  }

}
