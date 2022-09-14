package com.example.vacation_list_rest.api.logic;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

// реализуем метод, который проверяет, можем ли мы добавить данный отпуск на основании даты не превышающую количество рабочих дней
// до момента старта отпуска
// если срок меньше то функция возвращает false
// если срок больше то функция возвращает true

public class VacationCalendarDate {


    public boolean dateStart(String date, long day){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendarFrom = new GregorianCalendar();

        try {
            calendarFrom.setTime(sdf.parse(date));
            long workDay = 0;

            while (!calendar.after(calendarFrom))
            {

                int myDay = calendar.get(Calendar.DAY_OF_WEEK);

                if (myDay == Calendar.SATURDAY || myDay == Calendar.SUNDAY)
                {
                    calendar.add(Calendar.DAY_OF_WEEK,1);
                }
                else {
                    calendar.add(Calendar.DAY_OF_WEEK,1);
                    workDay++;
                }

            }
            return workDay > day;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
