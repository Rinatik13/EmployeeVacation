package com.example.vacation_list_rest.api.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class VacationDayCountTest extends VacationDayCount {

    @Test
    public void testGetVacationDay() {
        String dateStart = "01.01.2022";
        String dateEnd = "10.01.2022";
        int endCount = 10;
        int i = getVacationDay(dateStart,dateEnd);
        Assert.assertTrue(i==endCount);
    }
    @Test
    public void testGetVacationDay1() {
        String dateStart = "01.01.2022";
        String dateEnd = "1.01.2022";
        int endCount = 1;
        int i = getVacationDay(dateStart,dateEnd);
        Assert.assertTrue(i==endCount);
    }
    @Test
    public void testGetVacationDay2() {
        String dateStart = "01.01.2022";
        String dateEnd = "10.01.2022";
        int endCount = 5;
        int i = getVacationDay(dateStart,dateEnd);
        Assert.assertFalse(i==endCount);
    }
    @Test
    public void testGetVacationDay3() {
        String dateStart = "01.01.2022";
        String dateEnd = "31.12.2022";
        int endCount = 365;
        int i = getVacationDay(dateStart,dateEnd);
        Assert.assertTrue(i==endCount);
    }
    @Test
    public void testGetVacationDay4() {
        String dateStart = "01.01.2021";
        String dateEnd = "10.01.2022";
        int endCount = 10;
        int i = getVacationDay(dateStart,dateEnd);
        Assert.assertFalse(i==endCount);
    }
    @Test
    public void testGetVacationDay5() {
        String dateStart = "01.01.1990";
        String dateEnd = "10.01.2022";
        int endCount = 10;
        int i = getVacationDay(dateStart,dateEnd);
        Assert.assertFalse(i==endCount);
    }

    @Test
    public void testGetVacationYearDay1() {
        String dateStart = "22.12.2021";
        String dateEnd = "10.01.2022";
        int count2021 = 10;
        int count2022 = 10;
        Map<String, Integer> mapExpResult = new HashMap<>();
        mapExpResult.put("2021", count2021);
        mapExpResult.put("2022",count2022);
        Map<String, Integer> mapResult = getVacationYearDay(dateStart,dateEnd);
        Assert.assertTrue(mapExpResult.equals(mapResult));
    }
    @Test
    public void testGetVacationYearDay2() {
        String dateStart = "21.12.2021";
        String dateEnd = "10.01.2022";
        int count2021 = 11;
        int count2022 = 10;
        Map<String, Integer> mapExpResult = new HashMap<>();
        mapExpResult.put("2021", count2021);
        mapExpResult.put("2022",count2022);
        Map<String, Integer> mapResult = getVacationYearDay(dateStart,dateEnd);
        Assert.assertTrue(mapExpResult.equals(mapResult));
    }
    @Test
    public void testGetVacationYearDay3() {
        String dateStart = "25.12.2021";
        String dateEnd = "5.01.2022";
        int count2021 = 7;
        int count2022 = 5;
        Map<String, Integer> mapExpResult = new HashMap<>();
        mapExpResult.put("2021", count2021);
        mapExpResult.put("2022",count2022);
        Map<String, Integer> mapResult = getVacationYearDay(dateStart,dateEnd);
        Assert.assertTrue(mapExpResult.equals(mapResult));
    }
}