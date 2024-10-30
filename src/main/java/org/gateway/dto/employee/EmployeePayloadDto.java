package org.gateway.dto.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gateway.dto.department.DepartmentPlainDto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record EmployeePayloadDto(
  String employeeId,
  String firstname,
  String lastname,
  String middlename,
  LocalDateTime dateOfBirth,
  String gender,
  Integer salary,
  @JsonProperty(value = "department") DepartmentPlainDto departmentPlainDto
) implements Serializable {


}
