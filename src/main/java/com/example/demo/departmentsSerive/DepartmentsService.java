package com.example.demo.departmentsSerive;

import com.example.demo.employeeService.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentsService {

    Employee findMaxSalaryByDepartment(int department);

    Employee findMinSalaryByDepartment(int department);

    double calculateAllMonthSalariesByDepartment(int department);

    List<Employee> printEmployeeByDepartments(int department);
}
