package com.example.vacation_list_rest.api.validation;

import org.junit.Assert;
import org.junit.Test;

public class EmailValidTest extends EmailValid {

    @Test
    public void testVlidationEmail() {
        String email = "rinat@yandex.ru";
        Assert.assertTrue(validationEmail(email));
    }
    @Test
    public void testVlidationEmailTextPlusNumber1() {
        String email = "rinat13@yandex.ru";
        Assert.assertTrue(validationEmail(email));
    }
    @Test
    public void testVlidationEmailTextPlusNumber2() {
        String email = "rinat13@yandex22.ru";
        Assert.assertTrue(validationEmail(email));
    }

    @Test
    public void testVlidationEmailTextPlusNumber3() {
        String email = "rinat13@yandex22.ru22";
        Assert.assertTrue(validationEmail(email));
    }
    @Test
    public void testVlidationEmailMin() {
        String email = "r";
        Assert.assertFalse(validationEmail(email));
    }
    @Test
    public void testVlidationEmailNull() {
        String email = "";
        Assert.assertFalse(validationEmail(email));
    }

    @Test
    public void testVlidationEmailMax() {
        String email = "12345678901234567890123456789012345678901234567890";
        Assert.assertFalse(validationEmail(email));
    }

    @Test
    public void testVlidationEmailSimbol() {
        String email = ".,.,.,.@.,.,.ru";
        Assert.assertFalse(validationEmail(email));
    }
    @Test
    public void testVlidationEmailSimbol2() {
        String email = "*@*.r";
        Assert.assertFalse(validationEmail(email));
    }
    @Test
    public void testVlidationEmailSimbol3() {
        String email = "yandex@yand@ex.ru";
        Assert.assertFalse(validationEmail(email));
    }
    @Test
    public void testVlidationEmailSimbol5() {
        String email = "yandex@ya@d@ex.ru";
        Assert.assertFalse(validationEmail(email));
    }
}