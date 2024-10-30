package org.gateway.dto.department.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gateway.dto.department.DepartmentPlainDto;

import java.io.Serializable;

public record DepartmentLocationPayloadDto(
  String location,
  @JsonProperty(value = "department") DepartmentPlainDto departmentPlainDto
) implements Serializable {

}
