package org.gateway.dto.department.location;

import org.gateway.dto.department.DepartmentMapper;
import org.gateway.service.department.DepartmentResponseProto;
import org.gateway.service.department.location.DepartmentLocationPlainDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  typeConversionPolicy = ReportingPolicy.WARN
)
public interface  DepartmentLocationMapper {

  DepartmentLocationMapper INSTANCE = Mappers.getMapper(DepartmentLocationMapper.class);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "location", target = "location")
  DepartmentLocationPlainDto departmentLocationPlainProtoToDepartmentLocationPlainDto(
    DepartmentResponseProto.DepartmentLocationPlainProto departmentLocationPlainProto
  );
}
