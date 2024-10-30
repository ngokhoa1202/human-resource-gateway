package org.gateway.dto.department.location;

import java.io.Serializable;

public record DepartmentLocationPlainDto(
  Long id,
  String location
) implements Serializable {
}
