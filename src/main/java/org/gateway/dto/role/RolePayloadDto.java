package org.gateway.dto.role;


import java.io.Serializable;

public record RolePayloadDto(
  String name
) implements Serializable {

}
