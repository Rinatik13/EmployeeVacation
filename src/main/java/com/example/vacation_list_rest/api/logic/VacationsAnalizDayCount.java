package com.example.vacation_list_rest.api.logic;

import com.example.vacation_list_rest.api.entity.Vacation;
import com.example.vacation_list_rest.api.entity.VacationType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// делаем анализ взятых отпусков сотрудника ранее
// если суммарное количество отпускных дней больше заданного количества то возвращаем false
// если суммарное количество меньше отпускных дней и тех дней на которые берётся отпуск то возвращаем true

public class VacationsAnalizDayCount {

    public boolean analizVacations(Vacation vacation, List<Vacation> vacations, int day)
    {
        VacationDayCount vacationDayCount = new VacationDayCount();
        Map<String, Integer> countDayToYear = new HashMap<>();
        // проверяем текущий запрос на отпуск является оплачиваемым или нет
        if (vacation.getType() == VacationType.PAID) {

            // создаём список отпусков
            List<Vacation> vacationsEmployee = new ArrayList<>();

            // начинаем цикл (собираем данные для подсчёта количества дней которые сотрудник уже брал как
            // оплачиваемый отпуск
            for (Vacation vac : vacations) {

                // выбираем только те отпуска, где наш пользователь и тип оплачиваемый
                if (vac.getUserId() == vacation.getUserId() && vac.getType() == VacationType.PAID) {
                    vacationsEmployee.add(vac);
                }
            }

            String dateFrom = vacation.getDateFrom();
            String dateTo = vacation.getDateTo();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Calendar calendar = new GregorianCalendar();

            try {
                calendar.setTime(sdf.parse(dateFrom));
                calendar.setTime(sdf.parse(dateTo));

                // перебираем все наши оплачиваемые отпуска
                // пока за весь период! не разделено по годам!!
                // заполняем количество отпускных дней
                Map<String, Integer> resultMap = new HashMap<>();
                for (Vacation vac : vacationsEmployee) {
                    countDayToYear = vacationDayCount.getVacationYearDay(vac.getDateFrom(), vac.getDateTo());
                    for (Map.Entry<String, Integer> entry : countDayToYear.entrySet()) {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + entry.getValue());
                    }
                }
                for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                    if (entry.getValue()>day){
                        return false;
                    }
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            }
        return true;
    }
}