package org.gateway.exception.handler;

import io.grpc.StatusRuntimeException;
import org.gateway.exception.GatewayException;

public interface ExceptionHandler {

  GatewayException convert(StatusRuntimeException exception);
}
