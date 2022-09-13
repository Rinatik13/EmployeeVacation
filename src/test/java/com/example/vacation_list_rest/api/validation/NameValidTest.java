package com.example.vacation_list_rest.api.validation;

import org.junit.Assert;
import org.junit.Test;



public class NameValidTest extends NameValid {

    @Test
    public void testValidationNameText() {
        String name = "Ivanov";
        Assert.assertTrue(validationName(name));
    }

    @Test
    public void testValidationNameNumber(){
        String name = "123";
        Assert.assertTrue(validationName(name));
    }

    @Test
    public void testValidationNameSimbol(){
        String name = "!!!!";
        Assert.assertFalse(validationName(name));
    }

    @Test
    public void testValidationNameProbel(){
        String name = "     ";
        Assert.assertFalse(validationName(name));
    }

    @Test
    public void testValidationNameMinText(){
        String name = "a";
        Assert.assertFalse(validationName(name));
    }

    @Test
    public void testValidationNameMaxText(){
        String name = "qwertyuiop qwertyuiop qwertyuiop qwertyuiop qwertyuiop";
        Assert.assertFalse(validationName(name));
    }

    @Test
    public void testValidationNameNull(){
        String name = "";
        Assert.assertFalse(validationName(name));
    }
}