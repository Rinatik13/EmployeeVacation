package com.example.vacation_list_rest.api.DaO.vacation;

import com.example.vacation_list_rest.api.entity.Employee;
import com.example.vacation_list_rest.api.entity.Vacation;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VacationDaOImpl implements VacationDaO{
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Vacation> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Vacation> vacationQuery = session.createQuery("from Vacation",
                Vacation.class);
        return vacationQuery.getResultList();
    }

    @Override
    public Vacation addVacation(Vacation vacation) {
        System.out.println(vacation.getId());
        System.out.println(vacation.getUserId());
        System.out.println(vacation.getType());
        System.out.println(vacation.getDateFrom());
        System.out.println(vacation.getDateTo());
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(vacation);
        return vacation;
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Vacation vacation = session.get(Vacation.class,id);
        session.delete(vacation);
    }

    @Override
    public Vacation getVacation(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Vacation.class,id);

    }

    @Override
    public Vacation editVacation(Vacation vacation) {
        Session session = entityManager.unwrap(Session.class);
        session.save(vacation);
        return vacation;
    }
}
