package org.gateway.dto.role;


import java.io.Serializable;

public record RolePlainDto(
  Integer id,
  String name
) implements Serializable {

}
