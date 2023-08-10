package com.kk.ems.department.service.impl;

import com.kk.ems.department.dao.DepartmentDaoImpl;
import com.kk.ems.department.model.Department;
import com.kk.ems.department.service.DepartmentService;
import com.kk.ems.department.wrapper.DepartmentWrapper;
import com.kk.ems.employee.EmployeeWrapper;
import com.kk.ems.employee.model.Employee;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

@ApplicationScoped
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDaoImpl departmentDao;

    @Inject
    public DepartmentServiceImpl(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    @Transactional
    public Department create(Department department) {
        departmentDao.persistAndFlush(department);
        return department;
    }

    @Override
    public List<DepartmentWrapper> getAllDepartments() {
        PanacheQuery<Department> departmentList = departmentDao.findAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return departmentList.stream().map(dep -> {
            LongSummaryStatistics collect = dep.getEmployees().stream().collect(Collectors.summarizingLong(Employee::getSalary));
            List<EmployeeWrapper> empList = dep.getEmployees().stream().map(employee -> new EmployeeWrapper(employee, simpleDateFormat)).collect(Collectors.toList());
            return new DepartmentWrapper(dep.getDepartmentId(), dep.getName(), collect.getSum(), (long) dep.getEmployees().size(), empList);
        }).collect(Collectors.toList());
    }
}
