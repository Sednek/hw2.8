package com.example.demo.departmentsSerive;

import com.example.demo.employeeService.Employee;
import com.example.demo.employeeService.EmployeeService;
import com.example.demo.employeeService.EmployeeServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    EmployeeService employeeService = new EmployeeServiceImpl();
    private final List<Employee> employees = employeeService.getEmployees();


    public Employee findMaxSalaryByDepartment(int department) {
        Employee maxSalaryEmployee = employees.get(0);
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

    }

    public Employee findMinSalaryByDepartment(int department) {
        Employee minSalaryEmployee = employees.get(0);
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public double calculateAllMonthSalariesByDepartment(int department) {
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }

    public List<Employee> printEmployeeByDepartments(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
}
