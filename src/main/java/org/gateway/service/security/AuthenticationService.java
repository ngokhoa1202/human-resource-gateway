package org.gateway.service.security;

import io.grpc.StatusRuntimeException;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.gateway.dto.token.JwtDto;
import org.gateway.dto.token.JwtMapper;
import org.gateway.dto.user.UserLoginDto;
import org.gateway.dto.user.UserMapper;
import org.gateway.dto.user.UserResponseDto;
import org.gateway.service.authentication.AuthenticationGrpcService;
import org.gateway.service.authentication.UserIdProto;
import org.gateway.service.authentication.UserLoginProto;

import java.time.Duration;
import java.util.UUID;

@ApplicationScoped
public class AuthenticationService {

  @GrpcClient(value = "authenticationGrpcService")
  protected AuthenticationGrpcService authenticationGrpcService;

  public static final long AUTHENTICATION_WAITING_TIME = 2_000_000;

  public JwtDto login(UserLoginDto userLoginDto) throws StatusRuntimeException {
    UserLoginProto userLoginProto = UserMapper.INSTANCE.userLoginDtoToUserLoginProto(userLoginDto);
    return this.authenticationGrpcService.login(userLoginProto)
      .onItem().transform(JwtMapper.INSTANCE::jwtProtoToJwtDto)
      .await().atMost(Duration.ofMillis(AUTHENTICATION_WAITING_TIME));
  }

  public UserResponseDto getUser(UUID id) throws StatusRuntimeException {
    UserIdProto userIdProto = UserIdProto.newBuilder().setId(id.toString()).build();
    return this.authenticationGrpcService.getUser(userIdProto)
      .onItem().transform(UserMapper.INSTANCE::userResponseProtoToUserResponseDto)
      .await().atMost(Duration.ofMillis(AUTHENTICATION_WAITING_TIME));
  } 

}
