package com.kk.ems.department.rest;

import com.kk.ems.department.model.Department;
import com.kk.ems.department.service.DepartmentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/department")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentRestImpl {

    private final DepartmentService departmentService;

    @Inject
    public DepartmentRestImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @POST
    public Response create(Department department) {
        log.info("Department :: {}", department);
        return departmentService.create(department);
    }
}