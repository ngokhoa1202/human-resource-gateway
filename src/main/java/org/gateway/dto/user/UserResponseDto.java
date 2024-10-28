package org.gateway.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gateway.dto.role.RolePlainDto;

import java.util.UUID;

public record UserResponseDto(
  UUID id,
  String username,
  String password,
  String email,
  @JsonProperty(value = "role") RolePlainDto rolePlainDto
  ) {

}
