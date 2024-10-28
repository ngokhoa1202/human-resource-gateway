package org.gateway.dto.token;

import java.io.Serializable;

public record JwtDto(
  String token
) implements Serializable {

}
