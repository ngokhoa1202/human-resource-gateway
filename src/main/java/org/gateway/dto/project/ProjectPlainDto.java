package org.gateway.dto.project;


import java.io.Serializable;

public record ProjectPlainDto(
  Long id,
  String name,
  String area
) implements Serializable {

}
