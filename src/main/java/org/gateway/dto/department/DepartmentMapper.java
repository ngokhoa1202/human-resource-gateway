package org.gateway.dto.department;

import org.gateway.dto.department.location.DepartmentLocationMapper;
import org.gateway.service.department.DepartmentResponseProto;
import org.gateway.service.department.location.DepartmentLocationPlainDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  typeConversionPolicy = ReportingPolicy.WARN,
  uses = {
    DepartmentLocationMapper.class
  }
)
public interface DepartmentMapper {

  DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);


  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "locationProtosList", target = "locationPlainDtos")
  @Mapping(source = "startDate", target = "startDate")
  DepartmentResponseDto departmentResponseProtoToDepartmentResponseDto(DepartmentResponseProto departmentResponseProto);

}
