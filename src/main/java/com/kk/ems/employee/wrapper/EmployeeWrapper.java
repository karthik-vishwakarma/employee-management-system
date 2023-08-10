package com.kk.ems.employee.wrapper;

import com.kk.ems.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWrapper {
    private String employeeId;
    private String dateOfBirth;
    private Long salary;

    public EmployeeWrapper(Employee emp, SimpleDateFormat simpleDateFormat) {
        this.employeeId = emp.getEmployeeId();
        this.dateOfBirth = simpleDateFormat.format(emp.getDateOfBirth());
        this.salary = emp.getSalary();
    }
}