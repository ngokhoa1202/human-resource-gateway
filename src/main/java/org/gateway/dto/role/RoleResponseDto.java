package org.gateway.dto.role;

import java.io.Serializable;

public record RoleResponseDto(
  Integer id,
  String name
) implements Serializable {
}
