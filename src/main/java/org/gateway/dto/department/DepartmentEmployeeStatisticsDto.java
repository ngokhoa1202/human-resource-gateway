package org.gateway.dto.department;

import java.io.Serializable;
import java.time.LocalDateTime;

public record DepartmentEmployeeStatisticsDto(
  Long id,
  String name,
  LocalDateTime startDate,
  Long numberOfEmployees,
  Long totalSalary,
  Long minimumSalary,
  Long maximumSalary,
  Double averageSalary
) implements Serializable {

}
