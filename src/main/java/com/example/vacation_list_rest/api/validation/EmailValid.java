package com.example.vacation_list_rest.api.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// проверяем соответствие шаблону электронной почты
// если не соответствует шаблону, то возвращает false
// если соответствует шаблону, то возвращает true
// так же проверяем длинну электронной почты от 5 до 45 символов
public class EmailValid {
    public static boolean validationEmail(String email){
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)\\w\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        if (email.length()<5||email.length()>45){
            return false;
        }
        else if (!matcher.find()){
            return false;
        }
        else {
            return true;
        }
    }
}
