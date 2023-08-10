package com.kk.ems.employee.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kk.ems.department.model.Department;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity

@Table(name = "Employee")
public class Employee {

    @Id
    @Column(length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String employeeId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "departmentId")
    private Department department;

    private Date dateOfBirth;

    @Column(precision = 10, scale = 2)
    private BigDecimal salary;
}
