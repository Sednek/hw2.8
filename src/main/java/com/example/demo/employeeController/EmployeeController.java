package com.example.demo.employeeController;


import com.example.demo.employeeService.Employee;
import com.example.demo.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String printHello() {
        return "<b>Добро пожаловать в сервис по работе с сотрудниками";
    }

    @GetMapping(path = "/add-employee")
    public Employee addEmployee(@RequestParam(value = "name") String name, @RequestParam(value = "department") int department, @RequestParam(value = "salary") int salary) {
        return employeeService.addEmployee(name, department, salary);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.printEmployeesFromDepartments();
    }

}
