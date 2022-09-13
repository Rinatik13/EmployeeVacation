package com.example.vacation_list_rest.api.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// проверяем id в телеграмме
// проверяем с @
// если не соответствует шаблону то возвращаем false
// если соответствует то возвращаем true
public class TelegramIdValid {
    public static boolean validationTelegramId(String telegramId){
        Pattern pattern = Pattern.compile("@+\\w{5,45}$");
        Matcher matcher = pattern.matcher(telegramId);
        return matcher.find();
    }
}
