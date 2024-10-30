package org.gateway.dto.project;

import org.gateway.dto.department.DepartmentMapper;
import org.gateway.service.project.assignment.AssignmentPayloadProto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  typeConversionPolicy = ReportingPolicy.WARN,
  uses = {
    DepartmentMapper.class
  }
)
public interface ProjectMapper {

  static final ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "area", target = "area")
  AssignmentPayloadProto.ProjectPlainProto projectPlainDtoToProjectPlainProto(ProjectPlainDto projectPlainDto);
}
