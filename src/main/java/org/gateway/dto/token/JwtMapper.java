package org.gateway.dto.token;

import org.gateway.service.authentication.JwtProto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  typeConversionPolicy = ReportingPolicy.WARN
)
public interface JwtMapper {

  static final JwtMapper INSTANCE = Mappers.getMapper(JwtMapper.class);

  @Mapping(source = "token", target = "token")
  JwtProto jwtDtoToJwtProto(JwtDto jwtDto);

  @Mapping(source = "token", target = "token")
  JwtDto jwtProtoToJwtDto(JwtProto jwtProto);
}
