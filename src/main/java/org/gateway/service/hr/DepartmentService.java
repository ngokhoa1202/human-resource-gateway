package org.gateway.service.hr;

import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.gateway.dto.department.DepartmentMapper;
import org.gateway.dto.department.DepartmentResponseDto;
import org.gateway.service.department.DepartmentGrpcService;
import org.gateway.service.department.DepartmentIdProto;

import java.time.Duration;

@ApplicationScoped
public class DepartmentService {

  @GrpcClient(value = "departmentGrpcService")
  protected DepartmentGrpcService departmentGrpcService;

  public static final int DEPARTMENT_SERVICE_WAITING_TIME = 2_000_000;

  public DepartmentResponseDto getDepartmentById(long id) {
    DepartmentIdProto departmentIdProto = DepartmentIdProto.newBuilder().setId(id).build();
    return this.departmentGrpcService.getDepartmentById(departmentIdProto)
      .onItem()
      .transform(DepartmentMapper.INSTANCE::departmentResponseProtoToDepartmentResponseDto)
      .await().atMost(Duration.ofMillis(DEPARTMENT_SERVICE_WAITING_TIME));
  }
}
