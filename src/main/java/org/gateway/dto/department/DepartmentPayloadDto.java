package org.gateway.dto.department;


import java.io.Serializable;
import java.time.LocalDateTime;

public record DepartmentPayloadDto(
  String name,
  LocalDateTime startDate
) implements Serializable {

}
