package com.example.vacation_list_rest.api.controller;

import com.example.vacation_list_rest.api.entity.Employee;
import com.example.vacation_list_rest.api.service.employee.EmployeeService;
import com.example.vacation_list_rest.api.validation.EmailValid;
import com.example.vacation_list_rest.api.validation.NameValid;
import com.example.vacation_list_rest.api.validation.PhoneValid;
import com.example.vacation_list_rest.api.validation.TelegramIdValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PutMapping("")
    public Employee addEmployee(@RequestBody  Employee employee){
        if (NameValid.validationName(employee.getName()) && EmailValid.validationEmail(employee.getEmail())
        && PhoneValid.validationPhoneNumber(employee.getPhone())
        && TelegramIdValid.validationTelegramId(employee.getTelegramId())){
            return employeeService.saveEmployee(employee);
        }
        else {
            return null;
        }
    }

    @PatchMapping("/{id}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable int id){
        if (NameValid.validationName(employee.getName()) && EmailValid.validationEmail(employee.getEmail())
                && PhoneValid.validationPhoneNumber(employee.getPhone())
                && TelegramIdValid.validationTelegramId(employee.getTelegramId())){
            employee.setId(id);
            return employeeService.saveEmployee(employee);
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
