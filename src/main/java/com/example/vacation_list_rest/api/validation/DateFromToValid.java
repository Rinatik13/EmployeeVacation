package com.example.vacation_list_rest.api.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// проверка сроков начала и окончания отпуска
// если дата начала отпуска больше даты окончания отпуска то метод возвращает false
// если дата начала отпуска меньше даты окончания отпуска то метод возвращает true
public class DateFromToValid {
    public static boolean equalsDateFromTo(String dateFrom, String dateTo){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendarFrom = new GregorianCalendar();
        Calendar calendarTo = new GregorianCalendar();

        try {
            calendarFrom.setTime(sdf.parse(dateFrom));
            calendarTo.setTime(sdf.parse(dateTo));
            Date dateFrom1 = calendarFrom.getTime();
            Date dateTo1 = calendarTo.getTime();
            if (dateFrom1.getTime()<dateTo1.getTime()){
                return true;
            }
            else {
                return false;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
