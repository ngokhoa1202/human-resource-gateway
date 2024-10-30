package org.gateway.dto.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gateway.dto.department.DepartmentPlainDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record EmployeeDepartmentAssignmentStatisticsDto(
  UUID id,
  String employeeId,
  String firstname,
  String lastname,
  String middlename,
  LocalDateTime dateOfBirth,
  GenderEnum gender,
  Integer salary,
  @JsonProperty(value = "department") DepartmentPlainDto departmentPlainDto,
  Double hoursSpentPerAssignment,
  Long totalHours,
  Long numberOfAssignments
) implements Serializable {

}
