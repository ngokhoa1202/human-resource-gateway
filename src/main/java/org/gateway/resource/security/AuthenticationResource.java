package org.gateway.resource.security;


import io.grpc.StatusRuntimeException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.gateway.dto.token.JwtDto;
import org.gateway.dto.user.UserLoginDto;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.gateway.dto.user.UserResponseDto;
import org.gateway.exception.handler.ExceptionHandler;
import org.gateway.exception.GatewayException;
import org.gateway.service.security.AuthenticationService;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.UUID;


@Path("security")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
@RequiredArgsConstructor
public class AuthenticationResource {

  private final AuthenticationService authenticationService;

  private final ExceptionHandler exceptionHandler;

  @POST
  @Path(value = "login")
  public RestResponse<JwtDto> login(@RequestBody UserLoginDto userLoginDto) throws GatewayException {
    try {
      JwtDto jwtDto = this.authenticationService.login(userLoginDto);
      return RestResponse.ok(jwtDto);
    } catch (StatusRuntimeException exception) {
      throw this.exceptionHandler.convert(exception);
    }
  } 

//  @Path("user")
//  @POST
//  @RolesAllowed({"admin"})
//  public RestResponse<String> createUser(@RequestBody UserPayloadDto userPayloadDto)
//    throws SecurityException {
//
//    try {
//      UserResponseDto userResponseDTO = this.authenticationService.createUser(userPayloadDto);
//      return RestResponse.created(URI.from(userResponseDTO.id().toString()));
//    } catch (ConstraintViolationException | JDBCException ex) {
//      throw this.exceptionConverter.convert(ex);
//    }
//  }
//
  @Path("users/{id}")
  @GET
  @RolesAllowed({"admin"})
  public RestResponse<UserResponseDto> getUser(@RestPath(value = "id") UUID id) throws GatewayException {
    try {
      UserResponseDto userResponseDTO = this.authenticationService.getUser(id);
      return RestResponse.ok(userResponseDTO);
    } catch (StatusRuntimeException e) {
      throw this.exceptionHandler.convert(e);
    }
  }  
//  @Path("role/{id}")
//  @GET
//  @RolesAllowed({"admin"})
//  public RestResponse<RoleResponseDto> getRole(@RestPath(value = "id") Long id) throws SecurityException {
//    RoleResponseDto roleResponseDTO = this.authenticationService.getRole(id);
//    return RestResponse.ok(roleResponseDTO);
//  }
//
//  @Path("role")
//  @POST
//  @RolesAllowed({"admin"})
//  public RestResponse<String> createRole(@RequestBody RolePayloadDto rolePayloadDto) throws SecurityException {
//    try {
//      RoleResponseDto roleResponseDTO = this.authenticationService.createRole(rolePayloadDto);
//      return RestResponse.created(URI.from(roleResponseDTO.id().toString()));
//    } catch (JDBCException | ConstraintViolationException ex) {
//      throw this.exceptionConverter.convert(ex);
//    }
//
//  }
}
