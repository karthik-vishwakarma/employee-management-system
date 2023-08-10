package com.kk.ems.department.wrapper;

import com.kk.ems.employee.EmployeeWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentWrapper {
    private String departmentId;
    private String name;
    private Long totalSalary;
    private Long noOfEmployees;
    private List<EmployeeWrapper> employees;
}
