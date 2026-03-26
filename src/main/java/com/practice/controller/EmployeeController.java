package com.practice.controller;

import com.practice.entity.Employee;
import com.practice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Employee API";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("hello2")
    public String hello2(){
        return "Hello World 2nd time";
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/getAll")
    public List<Employee> findAll() {
        return employeeService.getAll();
    }
}
