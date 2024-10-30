package org.gateway.dto.department;


import org.gateway.service.department.location.DepartmentLocationPlainDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record DepartmentResponseDto(
  Long id,
  String name,
  LocalDateTime startDate,
  List<DepartmentLocationPlainDto> locationPlainDtos
) implements Serializable {


}
