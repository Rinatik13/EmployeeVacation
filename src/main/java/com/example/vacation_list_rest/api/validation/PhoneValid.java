package com.example.vacation_list_rest.api.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// валидация телефонного номера формата (+79876543210)
public class PhoneValid {
    public static boolean validationPhoneNumber(String phoneNumber){
        // проверяем соответствие шаблону (+798776543210)
        Pattern patternTruePattern = Pattern.compile("\\+\\d{11}$");
        Matcher matcherTruePattern = patternTruePattern.matcher(phoneNumber);
        return matcherTruePattern.find();
    }
}
