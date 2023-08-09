package com.kk.ems.department.dao;

import com.kk.ems.department.model.Department;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DepartmentDaoImpl implements PanacheRepository<Department> {
}
