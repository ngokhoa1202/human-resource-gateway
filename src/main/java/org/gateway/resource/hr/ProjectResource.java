package org.gateway.resource.hr;

import io.grpc.StatusRuntimeException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.gateway.dto.project.assignment.AssignmentPayloadDto;
import org.gateway.dto.project.assignment.AssignmentResponseDto;
import org.gateway.exception.GatewayException;
import org.gateway.exception.handler.ExceptionHandler;
import org.gateway.service.hr.AssignmentService;
import org.gateway.util.URIUtil;
import org.jboss.resteasy.reactive.RestResponse;

import java.net.URI;

@Path("projects")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ProjectResource {

  private final AssignmentService assignmentService;
  private final ExceptionHandler exceptionHandler;

  @POST
  @Path("assignments")
  @RolesAllowed(value = {"admin"})
  public RestResponse<String> createAssignment(@RequestBody AssignmentPayloadDto assignmentPayloadDto) throws GatewayException {
    try {
      AssignmentResponseDto assignmentResponseDto = this.assignmentService.createAssignment(assignmentPayloadDto);
      String uri = URIUtil.from(assignmentResponseDto.id(), "projects", "assignments");
      return RestResponse.created(URI.create(uri));
    } catch (StatusRuntimeException exception) {
      throw this.exceptionHandler.convert(exception);
    }
  }

}
