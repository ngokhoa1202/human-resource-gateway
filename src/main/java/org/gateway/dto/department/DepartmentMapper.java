package org.gateway.dto.department;

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
  typeConversionPolicy = ReportingPolicy.WARN
)
public interface DepartmentMapper {

  DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "location", target = "location")
  DepartmentLocationPlainDto departmentLocationPlainProtoToDepartmentLocationPlainDto(
    DepartmentResponseProto.DepartmentLocationPlainProto departmentLocationPlainProto
  );

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(
    source = "locationProtosList",
    target = "locationPlainDtos",
    qualifiedByName = "toDepartmentLocationPlainDtos"
  )
  @Mapping(source = "startDate", target = "startDate")
  DepartmentResponseDto departmentResponseProtoToDepartmentResponseDto(DepartmentResponseProto departmentResponseProto);


  @Named("toDepartmentLocationPlainDtos")
  default List<DepartmentLocationPlainDto> toDepartmentLocationPlainDtos(
    List<DepartmentResponseProto.DepartmentLocationPlainProto> departmentLocationPlainProtos
  ) {

    return departmentLocationPlainProtos.stream()
      .map(DepartmentMapper.INSTANCE::departmentLocationPlainProtoToDepartmentLocationPlainDto)
      .toList();
  }
}
