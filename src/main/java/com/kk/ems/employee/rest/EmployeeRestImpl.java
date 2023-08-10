package com.kk.ems.employee.rest;

import com.kk.ems.employee.model.Employee;
import com.kk.ems.employee.service.EmployeeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("employee")
@ApplicationScoped
public class EmployeeRestImpl {

    private final EmployeeService employeeService;

    @Inject
    public EmployeeRestImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @POST
    public Response create(Employee employee) {
        log.trace("Going to create employee having details : {}", employee);
        return Response.ok(employeeService.create(employee)).build();
    }
}
