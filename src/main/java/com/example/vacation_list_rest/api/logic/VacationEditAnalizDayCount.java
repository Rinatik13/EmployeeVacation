package com.example.vacation_list_rest.api.logic;

import com.example.vacation_list_rest.api.entity.Vacation;

import java.util.List;

// реализуем возможность внесение изменений в уже зарегистрированный отпуск
public class VacationEditAnalizDayCount {
    public boolean analiz(Vacation myVacation, Vacation vacation, List<Vacation> vacationList, int day) {
        VacationDayCount dayCount = new VacationDayCount();
        VacationsAnalizDayCount analizDayCount = new VacationsAnalizDayCount();
        // создаём переменную ИД
        int id = 0;
        // перебираем лист отпусков (вычисляем отпуск который уже зарегистрировали)
        // который хотим изменить
        for (Vacation vac : vacationList){
            if (vacation.getId()==vac.getId()){
                break;
            }
            id++;
        }
        // удаляем этот отпуск
        vacationList.remove(id);
        // проверяем если количество дней нового отпуска меньше или больше
        // если меньше то возвращаем true
        if (dayCount.getVacationDay(myVacation.getDateFrom(),myVacation.getDateTo())<dayCount.getVacationDay(vacation.getDateFrom(), vacation.getDateTo())){
            return true;
        }
        else {
            if(analizDayCount.analizVacations(myVacation,vacationList,day)){
                return true;
            }
            else return false;
        }
    }
}
