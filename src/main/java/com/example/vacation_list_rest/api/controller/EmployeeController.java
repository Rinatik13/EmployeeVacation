package com.example.vacation_list_rest.api.controller;

import com.example.vacation_list_rest.api.entity.Employee;
import com.example.vacation_list_rest.api.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/edit")
    public Employee editEmployee(@RequestBody Employee employee){
        return employeeService.editEmployee(employee);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
