package org.gateway.dto.department;

import java.io.Serializable;
import java.time.LocalDateTime;

public record DepartmentPlainDto(
  Long id,
  String name,
  LocalDateTime startDate
) implements Serializable {

}
