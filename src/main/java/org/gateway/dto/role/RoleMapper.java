package org.gateway.dto.role;

import org.gateway.service.authentication.UserPayloadProto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  typeConversionPolicy = ReportingPolicy.WARN
)
public interface RoleMapper {

  static final RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  RolePlainDto rolePlainProtoToRolePlainDto(UserPayloadProto.RolePlainProto rolePlainProto);
}
