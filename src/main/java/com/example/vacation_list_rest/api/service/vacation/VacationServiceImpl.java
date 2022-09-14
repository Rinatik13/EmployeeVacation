package com.example.vacation_list_rest.api.service.vacation;

import com.example.vacation_list_rest.api.DaO.employee.EmployeeDaO;
import com.example.vacation_list_rest.api.DaO.vacation.VacationDaO;
import com.example.vacation_list_rest.api.entity.Employee;
import com.example.vacation_list_rest.api.entity.Vacation;
import com.example.vacation_list_rest.api.entity.VacationType;
import com.example.vacation_list_rest.api.logic.VacationCalendarDate;
import com.example.vacation_list_rest.api.logic.VacationDayCount;
import com.example.vacation_list_rest.api.logic.VacationEditAnalizDayCount;
import com.example.vacation_list_rest.api.logic.VacationsAnalizDayCount;
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
        List<Vacation> vacations  = vacationDaO.getAll();
        List<Vacation> result = new ArrayList<>();
        for (Vacation vac: vacations) {
            if (vac.getUserId()==employeeId){
                result.add(vac);
            }
        }
        return result;
    }

    // реализуем метод добавления нового отпуска (не раньше 5 дней до начала отпуска)
    // при условии не более 28 дней общего количество взятых отпусков
    @Override
    @Transactional
    public Vacation saveVacation(Vacation vacation) {
        VacationCalendarDate date = new VacationCalendarDate();
        VacationsAnalizDayCount analizDayCount = new VacationsAnalizDayCount();
        List<Vacation> vacations = vacationDaO.getAll();
        if (date.dateStart(vacation.getDateFrom(), 5)) {
            if (analizDayCount.analizVacations(vacation, vacations, 28)) {
                return vacationDaO.addVacation(vacation);
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }


    // реализуем метод внесения изменений в отпуск (не раньше 3 дней до начала отпуска)
    // проверяем ранее записанный отпуск
    @Override
    @Transactional
    public Vacation editVacation(Vacation vacation) {
        VacationCalendarDate date = new VacationCalendarDate();
        VacationEditAnalizDayCount analizDayCount = new VacationEditAnalizDayCount();
        List<Vacation> vacations  = vacationDaO.getAll();
        List<Vacation> result = new ArrayList<>();
        for (Vacation vac: vacations) {
            if (vac.getUserId()==vacation.getUserId()){
                result.add(vac);
            }
        }

        // проверяем начало новой даты не раньше 3 дней
        if (date.dateStart(vacation.getDateFrom(),3)){
            Vacation myVacation = vacationDaO.getVacation(vacation.getId());
            // проверяем возможность внесения изменений
               if (analizDayCount.analiz(vacation,myVacation,result,28)){
                   return vacationDaO.addVacation(vacation);
               }
               else {
                   return null;
               }
        }
        else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        vacationDaO.delete(id);
    }
}
