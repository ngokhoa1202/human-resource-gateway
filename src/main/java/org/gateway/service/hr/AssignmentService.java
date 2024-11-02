package org.gateway.service.hr;

import io.grpc.StatusRuntimeException;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.gateway.dto.department.DepartmentResponseDto;
import org.gateway.dto.project.assignment.AssignmentMapper;
import org.gateway.dto.project.assignment.AssignmentPayloadDto;
import org.gateway.dto.project.assignment.AssignmentResponseDto;
import org.gateway.service.project.assignment.AssignmentGrpcService;
import org.gateway.service.project.assignment.AssignmentPayloadProto;

import java.time.Duration;

@ApplicationScoped
public class AssignmentService {

  public final static int ASSIGNMENT_SERVICE_WAITING_TIME = 2_000_000;

  @GrpcClient(value = "assignmentGrpcService")
  protected AssignmentGrpcService assignmentGrpcService;


  public AssignmentResponseDto createAssignment(AssignmentPayloadDto assignmentPayloadDto) throws StatusRuntimeException {
    AssignmentPayloadProto assignmentProto = AssignmentMapper.INSTANCE.assignmentPayloadProtoToAssignmentPayloadDto(assignmentPayloadDto);
    return this.assignmentGrpcService.createAssignment(assignmentProto)
      .onItem().transform(AssignmentMapper.INSTANCE::assignmentResponseProtoToAssignmentResponseDto)
      .await().atMost(Duration.ofMillis(ASSIGNMENT_SERVICE_WAITING_TIME));
  }
}
