package org.gateway.dto.user;

import org.gateway.dto.role.RoleMapper;
import org.gateway.service.authentication.UserLoginProto;
import org.gateway.service.authentication.UserResponseProto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  typeConversionPolicy = ReportingPolicy.WARN,
  uses = {
    RoleMapper.class
  }
)
public interface UserMapper {

  static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(source = "username", target = "username")
  @Mapping(source = "password", target = "password")
  UserLoginProto userLoginDtoToUserLoginProto(UserLoginDto userLoginDto);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "username", target = "username")
  @Mapping(source = "password", target = "password")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "rolePlainProto", target = "rolePlainDto")
  UserResponseDto userResponseProtoToUserResponseDto(UserResponseProto userResponseProto);
}
