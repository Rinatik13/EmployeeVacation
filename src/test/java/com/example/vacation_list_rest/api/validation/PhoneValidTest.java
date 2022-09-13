package com.example.vacation_list_rest.api.validation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneValidTest extends PhoneValid {

    @Test
    public void testValidationPhoneNumber() {
        String phoneNumber = "+79872422185";
        Assert.assertTrue(validationPhoneNumber(phoneNumber));
    }
    @Test
    public void testValidationPhoneNumberNull() {
        String phoneNumber = "";
        Assert.assertFalse(validationPhoneNumber(phoneNumber));
    }
    @Test
    public void testValidationPhoneNumberMin() {
        String phoneNumber = "+798";
        Assert.assertFalse(validationPhoneNumber(phoneNumber));
    }
    @Test
    public void testValidationPhoneNumberSize() {
        String phoneNumber = "+7987654321000";
        Assert.assertFalse(validationPhoneNumber(phoneNumber));
    }
    @Test
    public void testValidationPhoneNumberText() {
        String phoneNumber = "+abcabcdfabc";
        Assert.assertFalse(validationPhoneNumber(phoneNumber));
    }
}