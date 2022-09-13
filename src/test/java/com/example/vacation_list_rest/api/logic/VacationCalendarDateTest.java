package com.example.vacation_list_rest.api.logic;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.SimpleFormatter;

import static org.junit.Assert.*;

public class VacationCalendarDateTest extends VacationCalendarDate {

    @Test
    public void testDateStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,4);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(calendar.getTime());
        long day = 2;
        Assert.assertTrue(dateStart(date,day));
    }
    @Test
    public void testDateStart2() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(calendar.getTime());
        long day = 2;
        Assert.assertFalse(dateStart(date,day));
    }
    @Test
    public void testDateStart3() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,3);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(calendar.getTime());
        long day = 5;
        Assert.assertFalse(dateStart(date,day));
    }
    @Test
    public void testDateStart4() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,55);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(calendar.getTime());
        long day = 5;
        Assert.assertTrue(dateStart(date,day));
    }
    @Test
    public void testDateStart5() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,8);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(calendar.getTime());
        long day = 3;
        Assert.assertTrue(dateStart(date,day));
    }
    @Test
    public void testDateStart6() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,8);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(calendar.getTime());
        long day = 5;
        Assert.assertTrue(dateStart(date,day));
    }
}