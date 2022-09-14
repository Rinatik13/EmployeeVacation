package com.example.vacation_list_rest.api.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

// реализуем метод проверки даты на реальное сушествование
// к примеру не допустимости записи 31.02.2022
// если дата не может существовать то возвращаем false
// если дата имеет право на существование то возвращаем true
public class ValidationDateNotNull {
    public static boolean validationDataNotNull(String date){
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);

        try {
            calendar.setTime(sdf.parse(date));
//            calendar.setLenient(false);
            calendar.getTime();
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
