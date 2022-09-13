package com.example.vacation_list_rest.api.validation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateValidTest extends DateValid {

    @Test
    public void testValidationDate() {
        String date = "01.01.2001";
        Assert.assertTrue(validationDate(date));
    }
    @Test
    public void testValidationDate2() {
        String date = "01.01.2001";
        Assert.assertTrue(validationDate(date));
    }
    @Test
    public void testValidationDateNull() {
        String date = "0.00.0000";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateText() {
        String date = "a.aa.0000";
        Assert.assertFalse(validationDate(date));
    }

    @Test
    public void testValidationDateNull2() {
        String date = "";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateNull3() {
        String date = "text";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateNumberMinus() {
        String date = "-1.01.2022";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateNumberMinus2() {
        String date = "-1.-1.2022";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateNumberMax() {
        String date = "11111111111111111111111111111111111111.10.2022";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateNumberMax2() {
        String date = "1.10.99999";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateNumberMax3() {
        String date = "1.13.2022";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateSimbol() {
        String date = "#.10.2022";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateSimbol2() {
        String date = "1.#.2022";
        Assert.assertFalse(validationDate(date));
    }
    @Test
    public void testValidationDateNumber() {
        String date = "01.01.2022";
        Assert.assertTrue(validationDate(date));
    }
    @Test
    public void testValidationDateSimbol3() {
        String date = "......";
        Assert.assertFalse(validationDate(date));
    }
}