package com.kk.ems.department.service.impl;

import com.kk.ems.department.dao.DepartmentDaoImpl;
import com.kk.ems.department.model.Department;
import com.kk.ems.department.service.DepartmentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDaoImpl departmentDao;

    @Inject
    public DepartmentServiceImpl(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    @Transactional
    public Response create(Department department) {
        departmentDao.persistAndFlush(department);
        return Response.ok(department).build();
    }
}
