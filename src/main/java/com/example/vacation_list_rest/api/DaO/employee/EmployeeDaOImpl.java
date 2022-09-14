package com.example.vacation_list_rest.api.DaO.employee;

import com.example.vacation_list_rest.api.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaOImpl implements EmployeeDaO{
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> employeeQuery = session.createQuery("from Employee",
                Employee.class);
        return employeeQuery.getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class,id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public Employee editEmployee(Employee employee, int id) {
        Session session = entityManager.unwrap(Session.class);
        employee.setId(id);
//        Employee empl = session.get(Employee.class,id);
//        empl.setEmail(employee.getEmail());
//        empl.setName(employee.getName());
//        empl.setPhone(employee.getPhone());
//        empl.setTelegramId(employee.getTelegramId());
//        empl.setVacationList(employee.getVacationList());
        session.saveOrUpdate(employee);
        return employee;
    }


    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);
        session.delete(employee);
    }
}
