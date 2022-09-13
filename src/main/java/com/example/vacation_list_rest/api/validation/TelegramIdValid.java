package com.example.vacation_list_rest.api.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelegramIdValid {
    public static boolean validationTelegramId(String telegramId){
        Pattern pattern = Pattern.compile("@+\\w{5,45}$");
        Matcher matcher = pattern.matcher(telegramId);
        return matcher.find();
    }
}
