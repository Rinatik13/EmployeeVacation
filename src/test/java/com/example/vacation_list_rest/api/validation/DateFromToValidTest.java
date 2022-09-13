package com.example.vacation_list_rest.api.validation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateFromToValidTest extends DateFromToValid {

    @Test
    public void testEqualsDateFromTo1() {
        String dateFrom = "10.01.2022";
        String dateTo = "11.01.2022";
        Assert.assertTrue(equalsDateFromTo(dateFrom,dateTo));
    }
    @Test
    public void testEqualsDateFromTo2() {
        String dateFrom = "10.01.2022";
        String dateTo = "11.01.2030";
        Assert.assertTrue(equalsDateFromTo(dateFrom,dateTo));
    }
    @Test
    public void testEqualsDateFromTo3() {
        String dateFrom = "10.01.2022";
        String dateTo = "11.11.2022";
        Assert.assertTrue(equalsDateFromTo(dateFrom,dateTo));
    }
    @Test
    public void testEqualsDateFromTo4() {
        String dateFrom = "10.01.2022";
        String dateTo = "01.01.2022";
        Assert.assertFalse(equalsDateFromTo(dateFrom,dateTo));
    }
    @Test
    public void testEqualsDateFromTo5() {
        String dateFrom = "15.02.2022";
        String dateTo = "11.01.2022";
        Assert.assertFalse(equalsDateFromTo(dateFrom,dateTo));
    }
    @Test
    public void testEqualsDateFromTo() {
        String dateFrom = "10.01.2022";
        String dateTo = "10.01.2022";
        Assert.assertFalse(equalsDateFromTo(dateFrom,dateTo));
    }
}