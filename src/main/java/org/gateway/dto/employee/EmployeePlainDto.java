package org.gateway.dto.employee;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


public record EmployeePlainDto(
  UUID id,
  String employeeId,
  String firstname,
  String lastname,
  String middlename,
  LocalDateTime dateOfBirth,
  String gender,
  Integer salary
) implements Serializable {

}
