package org.gateway.resource.hr;

import io.grpc.StatusRuntimeException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.gateway.dto.project.assignment.AssignmentPayloadDto;
import org.gateway.exception.GatewayException;
import org.jboss.resteasy.reactive.RestResponse;

@Path("projects")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {

  @POST
  @Path("assignments")
  public RestResponse<String> createAssignment(@RequestBody AssignmentPayloadDto assignmentPayloadDto) throws GatewayException {
    return RestResponse.ok();
  }
}
