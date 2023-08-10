package com.kk.ems.department.rest;

import com.kk.ems.department.model.Department;
import com.kk.ems.department.service.DepartmentService;
import com.kk.ems.department.wrapper.DepartmentWrapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
        log.trace("Going to create department having details : {}", department);
        return Response.ok(departmentService.create(department)).build();
    }

    @GET
    public Response getAllDepartments() {
        log.trace("Going to get all department");
        List<DepartmentWrapper> departmentWrapperList = departmentService.getAllDepartments();
        return Response.ok(departmentWrapperList).build();
    }
}