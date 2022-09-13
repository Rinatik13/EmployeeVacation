package com.example.vacation_list_rest.api.service.employee;

import com.example.vacation_list_rest.api.DaO.employee.EmployeeDaO;
import com.example.vacation_list_rest.api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDaO employeeDaO;


    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDaO.getAll();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDaO.getEmployee(id);
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDaO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDaO.deleteEmployee(id);
    }
}
