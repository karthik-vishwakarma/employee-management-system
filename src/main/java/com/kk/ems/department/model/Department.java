package com.kk.ems.department.model;

import com.kk.ems.employee.model.Employee;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Department")
public class Department {

    @Id
    @Column(length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String departmentId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalSalary;

    private int noOfEmployees;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
}