package org.gateway.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gateway.dto.role.RolePlainDto;

import java.io.Serializable;


public record UserPayloadDto(
  String username,
  String password,
  String email,
  @JsonProperty(value = "role") RolePlainDto rolePlainDto
) implements Serializable {

}
