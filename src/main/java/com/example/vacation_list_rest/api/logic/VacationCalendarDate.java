package com.example.vacation_list_rest.api.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// реализуем метод, который проверяет, можем ли мы добавить данный отпуск на основании даты
public class VacationCalendarDate {


    public boolean dateStart(String date, long day){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendarFrom = new GregorianCalendar();
        Date todayDate = calendar.getTime();

        try {
            calendarFrom.setTime(sdf.parse(date));
        Date dateFrom = calendarFrom.getTime();
        long resultDay = (dateFrom.getTime()-todayDate.getTime())/86400000;
            return resultDay >= day;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
