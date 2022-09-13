package com.example.vacation_list_rest.api.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// проверка имени пользователя
// проверяем если в имени присутствуют символы то метод возвращает false
// если в имени отсутствуют симвобы то метод возвращает true
// проверяем длину имени, она должна быть от 2 до 45 символов
public class NameValid {
    public static boolean validationName(String name){
        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(name);
        if (name==""){
            return false;
        }
        else if(name.length()<2 || name.length()>45){
            return false;
        }
        else if(matcher.find()){
            return false;
        }
        else{
            return true;
        }

    }
}
