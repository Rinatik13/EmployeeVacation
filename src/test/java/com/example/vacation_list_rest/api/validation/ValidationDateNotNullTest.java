package com.example.vacation_list_rest.api.validation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationDateNotNullTest extends ValidationDateNotNull {

    @Test
    void testValidationDataNotNull() {
        String date = "01.01.2022";
        Assert.assertTrue(validationDataNotNull(date));
    }
    @Test
    void testValidationDataNotNull2() {
        String date = "31.02.2022";
        Assert.assertFalse(validationDataNotNull(date));
    }
    @Test
    void testValidationDataNotNull3() {
        String date = "31.09.2022";
        Assert.assertFalse(validationDataNotNull(date));
    }
    @Test
    void testValidationDataNotNull4() {
        String date = "29.02.2020";
        Assert.assertTrue(validationDataNotNull(date));
    }
}