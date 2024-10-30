package org.gateway.dto.project.assignment;

import org.gateway.dto.employee.EmployeeMapper;
import org.gateway.dto.project.ProjectMapper;
import org.gateway.service.project.assignment.AssignmentPayloadProto;
import org.gateway.service.project.assignment.AssignmentPayloadProtoOrBuilder;
import org.gateway.service.project.assignment.AssignmentResponseProto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  typeConversionPolicy = ReportingPolicy.WARN,
  uses = {
    EmployeeMapper.class,
    ProjectMapper.class
  }
)
public interface AssignmentMapper {

  static final AssignmentMapper INSTANCE = Mappers.getMapper(AssignmentMapper.class);

  @Mapping(source = "numberOfHours", target = "numberOfHours")
  @Mapping(source = "employeePlainDto", target = "employeePlainProto")
  @Mapping(source = "projectPlainDto", target = "projectPlainProto")
  AssignmentPayloadProto assignmentPayloadProtoToAssignmentPayloadDto(AssignmentPayloadDto assignmentPayloadDto);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "numberOfHours", target = "numberOfHours")
  @Mapping(source = "employeePlainProto", target = "employeePlainDto")
  @Mapping(source = "projectPlainProto", target = "projectPlainDto")
  AssignmentResponseDto assignmentResponseProtoToAssignmentResponseDto(AssignmentResponseProto assignmentResponseProto);
}
