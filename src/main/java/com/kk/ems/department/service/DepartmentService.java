package com.kk.ems.department.service;

import com.kk.ems.department.model.Department;
import com.kk.ems.department.wrapper.DepartmentWrapper;
import jakarta.transaction.Transactional;

import java.util.List;

public interface DepartmentService {
    @Transactional
    Department create(Department department);

    List<DepartmentWrapper> getAllDepartments();
}
