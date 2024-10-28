package org.gateway.service.hr;

import io.grpc.StatusRuntimeException;
import io.quarkus.grpc.GrpcClient;
import org.gateway.dto.project.assignment.AssignmentPayloadDto;
import org.gateway.dto.project.assignment.AssignmentResponseDto;
import org.gateway.service.project.assignment.AssignmentGrpcService;

public class AssignmentService {

  @GrpcClient("assignmentGrpcService")
  protected AssignmentGrpcService assignmentGrpcService;

//  public AssignmentResponseDto createAssignment(AssignmentPayloadDto assignmentPayloadDto) throws StatusRuntimeException {
//
//  }
}
