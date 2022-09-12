package com.example.vacation_list_rest.api.service.vacation;

import com.example.vacation_list_rest.api.DaO.vacation.VacationDaO;
import com.example.vacation_list_rest.api.entity.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class VacationServiceImpl implements VacationService{
    @Autowired
    VacationDaO vacationDaO;

    @Override
    @Transactional
    public List<Vacation> getAll() {
        return vacationDaO.getAll();
    }

    @Override
    @Transactional
    public List<Vacation> getEmployeeVacations(int employeeId) {
        List<Vacation> vacations = new ArrayList<>();
        vacations = vacationDaO.getAll();
        List<Vacation> result = new ArrayList<>();
        for (Vacation vac: vacations) {
            if (vac.getUserId()==employeeId){
                result.add(vac);
            }
        }
        return result;
    }

    @Override
    @Transactional
    public Vacation addVacation(Vacation vacation) {
        return vacationDaO.addVacation(vacation);
    }

    @Override
    @Transactional
    public Vacation editVacation(Vacation vacation) {
        return vacationDaO.editVacation(vacation);
    }

    @Override
    @Transactional
    public void delete(int id) {
        vacationDaO.delete(id);
    }
}
