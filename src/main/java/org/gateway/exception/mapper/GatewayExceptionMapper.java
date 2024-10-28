package org.gateway.exception.mapper;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.gateway.exception.GatewayException;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class GatewayExceptionMapper implements ExceptionMapper<GatewayException> {

  @Override
  public Response toResponse(GatewayException exception) {
    return exception.getResponse();
  }
}
