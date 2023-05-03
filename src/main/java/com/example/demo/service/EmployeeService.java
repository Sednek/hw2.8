package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee findMaxSalaryByDepartment(int department);

    Employee findMinSalaryByDepartment(int department);

    double calculateAllMonthSalariesByDepartment(int department);

    List<Employee> printEmployeeByDepartments(int department);

    Map<Integer, List<Employee>> printEmployeesFromDepartments();

    void addEmployee(Employee employee);

    void addEmployee(String name, int department, int salary);

}
