package org.gateway.resource.hr;

import io.grpc.StatusRuntimeException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.gateway.dto.department.DepartmentResponseDto;
import org.gateway.exception.GatewayException;
import org.gateway.exception.handler.ExceptionHandler;
import org.gateway.service.hr.DepartmentService;
import org.jboss.resteasy.reactive.RestResponse;

@ApplicationScoped
@Path(value = "departments")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@RequiredArgsConstructor
public class DepartmentResource {

  private final DepartmentService departmentService;

  private final ExceptionHandler exceptionHandler;

  @GET
  @Path(value = "")
  public RestResponse<DepartmentResponseDto> getDepartment(long id) throws GatewayException {
    try {
      DepartmentResponseDto departmentResponseDto = departmentService.getDepartmentById(id);
      return RestResponse.ok(departmentResponseDto);
    } catch (StatusRuntimeException exception) {
      throw this.exceptionHandler.convert(exception);
    }
  }
}
