package com.example.demo.employeeService;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee addEmployee(Employee employee);

    Employee addEmployee(String name, int department, int salary);

    Map<Integer, List<Employee>> printEmployeesFromDepartments();

}
