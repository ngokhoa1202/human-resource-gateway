package org.gateway.dto.employee;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record EmployeeAssignmentStatisticsDto(
  UUID id,
  String employeeId,
  String firstname,
  String lastname,
  String middlename,
  LocalDateTime dateOfBirth,
  GenderEnum gender,
  Integer salary,
  Long numberOfAssignments,
  Long totalHours,
  Double averageHoursPerAssignment
) implements Serializable {
}
