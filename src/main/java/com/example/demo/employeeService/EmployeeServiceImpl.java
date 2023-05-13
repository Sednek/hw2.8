package com.example.demo.employeeService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee addEmployee(String name, int department, int salary) {
        Employee e = new Employee(name, department, salary);
        employees.add(e);
        return e;
    }

    public Map<Integer, List<Employee>> printEmployeesFromDepartments() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
