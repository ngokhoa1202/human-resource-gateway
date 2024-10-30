package org.gateway.dto.department.location;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.gateway.dto.department.DepartmentPlainDto;

import java.io.Serializable;

public record DepartmentLocationResponseDTO(
  Long id,
  String location,
  @JsonProperty("department") DepartmentPlainDto departmentPlainDto
  ) implements Serializable {

}