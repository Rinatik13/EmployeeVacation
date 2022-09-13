package com.example.vacation_list_rest.api.validation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelegramIdValidTest extends TelegramIdValid {

    @Test
    public void testValidationTelegramIdText() {
        String telegramId = "@rinat";
        Assert.assertTrue(validationTelegramId(telegramId));
    }
    @Test
    public void testValidationTelegramIdNull() {
        String telegramId = "";
        Assert.assertFalse(validationTelegramId(telegramId));
    }
    @Test
    public void testValidationTelegramIdMin() {
        String telegramId = "@rin";
        Assert.assertFalse(validationTelegramId(telegramId));
    }
    @Test
    public void testValidationTelegramIdMax() {
        String telegramId = "@rinatrinatrinatrinatrinatrinatrinatrinatrinatrinat";
        Assert.assertFalse(validationTelegramId(telegramId));
    }
    @Test
    public void testValidationTelegramIdSimbol() {
        String telegramId = "@                ";
        Assert.assertFalse(validationTelegramId(telegramId));
    }
    @Test
    public void testValidationTelegramIdNumber() {
        String telegramId = "@1234567890";
        Assert.assertTrue(validationTelegramId(telegramId));
    }
    @Test
    public void testValidationTelegramIdNoSimbol() {
        String telegramId = "rinatik";
        Assert.assertFalse(validationTelegramId(telegramId));
    }
}