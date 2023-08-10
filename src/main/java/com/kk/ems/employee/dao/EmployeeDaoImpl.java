package com.kk.ems.employee.dao;

import com.kk.ems.employee.model.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeDaoImpl implements PanacheRepository<Employee> {

}
