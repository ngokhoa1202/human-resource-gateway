package org.gateway.dto.project.assignment;

import java.io.Serializable;

public record AssignmentPlainDto(
  Long id,
  Integer numberOfHours
) implements Serializable {

}
