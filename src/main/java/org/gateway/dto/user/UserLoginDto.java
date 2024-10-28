package org.gateway.dto.user;


import java.io.Serializable;

public record UserLoginDto(
  String username,
  String password
) implements Serializable {

}
