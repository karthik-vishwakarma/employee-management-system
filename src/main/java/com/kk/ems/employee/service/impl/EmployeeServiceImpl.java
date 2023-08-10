package com.kk.ems.employee.service.impl;

import com.kk.ems.employee.dao.EmployeeDaoImpl;
import com.kk.ems.employee.model.Employee;
import com.kk.ems.employee.service.EmployeeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDaoImpl employeeDao;

    @Inject
    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public Employee create(Employee employee) {
        log.info("Inside create having employee details : {}", employee);
        employeeDao.persist(employee);
        return employee;
    }
}
