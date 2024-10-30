package org.gateway.dto.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gateway.dto.department.DepartmentPlainDto;

import java.io.Serializable;

public record ProjectAssignmentStatisticsDto(
  Long id,
  String name,
  String area,
  @JsonProperty(value = "department") DepartmentPlainDto departmentPlainDto,
  Long numberOfAssignments,
  Long totalHours,
  Double hoursSpentPerAssignment
) implements Serializable {
}
