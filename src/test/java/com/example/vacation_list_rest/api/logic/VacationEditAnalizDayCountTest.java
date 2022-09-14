package com.example.vacation_list_rest.api.logic;

import com.example.vacation_list_rest.api.entity.Vacation;
import com.example.vacation_list_rest.api.entity.VacationType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VacationEditAnalizDayCountTest extends VacationEditAnalizDayCount {

    @Test
    public void testAnaliz() {
        Vacation myBDVacation = new Vacation();
        Vacation myNewVacation = new Vacation();
        myNewVacation.setId(0);
        myNewVacation.setType(VacationType.PAID);
        myNewVacation.setUserId(0);
        myNewVacation.setDateFrom("10.12.2022");
        myNewVacation.setDateTo("31.12.2022");
        // 2022 - 22
        List<Vacation> vacations = new ArrayList<>();
        Vacation vac = new Vacation();
        vac.setId(1);
        vac.setType(VacationType.PAID);
        vac.setUserId(0);
        vac.setDateFrom("01.11.2022");
        vac.setDateTo("05.11.2022");
        // 2022 - 5
        vacations.add(vac);

        myBDVacation.setId(0);
        myBDVacation.setType(VacationType.PAID);
        myBDVacation.setUserId(0);
        myBDVacation.setDateFrom("25.12.2022");
        myBDVacation.setDateTo("30.12.2022");
        // 2022 - 6
        vacations.add(myBDVacation);

        int day = 28;
        Assert.assertTrue(analiz(myNewVacation,myBDVacation,vacations,day));
    }
    @Test
    public void testAnaliz2() {
        Vacation myBDVacation = new Vacation();
        Vacation myNewVacation = new Vacation();
        myNewVacation.setId(0);
        myNewVacation.setType(VacationType.PAID);
        myNewVacation.setUserId(0);
        myNewVacation.setDateFrom("08.12.2022");
        myNewVacation.setDateTo("31.12.2022");
        // 2022 - 24
        List<Vacation> vacations = new ArrayList<>();
        Vacation vac = new Vacation();
        vac.setId(1);
        vac.setType(VacationType.PAID);
        vac.setUserId(0);
        vac.setDateFrom("01.11.2022");
        vac.setDateTo("05.11.2022");
        // 2022 - 5
        vacations.add(vac);

        myBDVacation.setId(0);
        myBDVacation.setType(VacationType.PAID);
        myBDVacation.setUserId(0);
        myBDVacation.setDateFrom("25.12.2022");
        myBDVacation.setDateTo("30.12.2022");
        // 2022 - 6
        vacations.add(myBDVacation);

        int day = 28;
        Assert.assertFalse(analiz(myNewVacation,myBDVacation,vacations,day));
    }
}