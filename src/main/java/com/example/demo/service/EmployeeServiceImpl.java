package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void addEmployee(String name, int department, int salary){
        Employee e = new Employee(name, department, salary);
        employees.add(e);
    }

    public Employee findMaxSalaryByDepartment(int department) {
        Employee maxSalaryEmployee = employees.get(0);
        return employees.stream()
                .filter(e -> e.getDepartment() == department && maxSalaryEmployee.getSalary() < e.getSalary())
                .findAny()
                .orElse(null);
    }

    public Employee findMinSalaryByDepartment(int department) {
        Employee minSalaryEmployee = employees.get(0);
        return employees.stream()
                .filter(e -> e.getDepartment() == department && minSalaryEmployee.getSalary() > e.getSalary())
                .findAny()
                .orElse(null);
    }

    public double calculateAllMonthSalariesByDepartment(int department) {
        final double[] sum = {0};
        employees.forEach( e -> sum[0] = sum[0] + e.getSalary());
        return sum[0];
    }

    public List<Employee> printEmployeeByDepartments(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> printEmployeesFromDepartments() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
