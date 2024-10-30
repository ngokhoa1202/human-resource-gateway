package org.gateway.dto.employee;

import org.gateway.dto.department.DepartmentMapper;
import org.gateway.service.project.assignment.AssignmentPayloadProto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Locale;

@Mapper(
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  typeConversionPolicy = ReportingPolicy.WARN,
  uses = {
    DepartmentMapper.class
  }
)
public interface EmployeeMapper {

  EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  @Named("toGenderEnum")
  default GenderEnum toGenderEnum(String gender) {
    return GenderEnum.valueOf(gender.toUpperCase(Locale.ROOT));
  }

  @Named("toGenderString")
  default String toGenderString(GenderEnum genderEnum) {
    return genderEnum.toString().toUpperCase(Locale.ROOT);
  }

  @Mapping(source = "id", target = "id")
  @Mapping(source = "employeeId", target = "employeeId")
  @Mapping(source = "firstname", target = "firstname")
  @Mapping(source = "lastname", target = "lastname")
  @Mapping(source = "middlename", target =  "middlename")
  @Mapping(source = "dateOfBirth", target = "dateOfBirth")
  @Mapping(source = "gender", target = "gender")
  AssignmentPayloadProto.EmployeePlainProto employeePlainDtoToEmployeePlainProto(EmployeePlainDto employeePlainDto);
}
