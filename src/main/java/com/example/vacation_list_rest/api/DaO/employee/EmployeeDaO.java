package com.example.vacation_list_rest.api.DaO.employee;

import com.example.vacation_list_rest.api.entity.Employee;

import java.util.List;

public interface EmployeeDaO {
    public List<Employee> getAll();
    public Employee getEmployee(int id);
    public Employee addEmployee(Employee employee);
    public void deleteEmployee(int id);

    public Employee editEmployee(Employee employee,int id);

}
