package com.example.demo.departmentsController;


import com.example.demo.departmentsSerive.DepartmentsService;
import com.example.demo.employeeService.Employee;
import com.example.demo.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping
    public String printHello() {
        return "<b>Добро пожаловать в сервис по работе с сотрудниками";
    }

    @GetMapping(path = "/max-salary")
    public Employee getEmployeeWithMaxSalaryByDepartment(@RequestParam(value = "departmentId") int departmentId) {
        return departmentsService.findMaxSalaryByDepartment(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAllEmployeesByDepartment(@RequestParam(value = "departmentId") int departmentId) {
        return departmentsService.printEmployeeByDepartments(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee getEmployeeWithMinSalaryByDepartment(@RequestParam(value = "departmentId") int departmentId) {
        return departmentsService.findMinSalaryByDepartment(departmentId);
    }

}
