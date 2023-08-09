package com.kk.ems.department.service;

import com.kk.ems.department.model.Department;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

public interface DepartmentService {
    @Transactional
    Response create(Department department);
}
