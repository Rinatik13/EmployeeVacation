package com.example.vacation_list_rest.api.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// проверяем соответствие шаблона даты
// если дата не соответствует шаблону то метод возвращает false
// если дата соответствует шаблону то метод возвращает true
// если количество дней и количество месяцев больше максимального их значения то возвращает false
// по умолчанию дней до 31, месяцы до 12.
public class DateValid {
    public static boolean validationDate(String date){
        Pattern pattern = Pattern.compile("^\\d{2}.\\d{2}.\\d{4}$");
        Matcher matcher = pattern.matcher(date);

        if (!matcher.find()){
            return false;
        }

        String [] dateStrings = date.split("\\.");
        int [] dateNumbers = new int[3];
        for (int i = 0; i<3;i++){
            dateNumbers[i] = Integer.parseInt(dateStrings[i]);
        }

        if (dateNumbers[0]>31 || dateNumbers[1] >12 || dateNumbers[0] == 0 || dateNumbers[1] == 0){
            return false;
        }
        else
        {
            return true;
        }
    }
}
