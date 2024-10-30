package org.gateway.dto.project.assignment;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gateway.dto.employee.EmployeePlainDto;
import org.gateway.dto.project.ProjectPlainDto;

import java.io.Serializable;

public record AssignmentResponseDto(
  Long id,
  Integer numberOfHours,
  @JsonProperty(value = "employee") EmployeePlainDto employeePlainDto,
  @JsonProperty(value = "project") ProjectPlainDto projectPlainDto
) implements Serializable {

}
