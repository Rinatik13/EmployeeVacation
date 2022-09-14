package com.example.vacation_list_rest.api.logic;

import com.example.vacation_list_rest.api.entity.Vacation;
import com.example.vacation_list_rest.api.entity.VacationType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VacationsAnalizDayCountTest extends VacationsAnalizDayCount {

    @Test
    public void testAnalizVacations() {
        Vacation vacation = new Vacation();
        vacation.setId(0);
        vacation.setType(VacationType.PAID);
        vacation.setUserId(0);
        vacation.setDateFrom("10.12.2022");
        vacation.setDateTo("15.12.2022");
        List<Vacation> vacations = new ArrayList<>();
        for (int i = 0; i<8; i++){
            Vacation vac = new Vacation();
            vac.setId(i+1);
            vac.setType(VacationType.PAID);
            vac.setUserId(0);
            vac.setDateFrom("10.0"+ (i+1) + ".2022");
            vac.setDateTo("20.0" + (i+1) + ".2022");
            vacations.add(vac);
        }
        int day = 100;
        Assert.assertTrue(analizVacations(vacation,vacations,day));
    }

    @Test
    public void testAnalizVacations2() {
        Vacation vacation = new Vacation();
        vacation.setId(0);
        vacation.setType(VacationType.PAID);
        vacation.setUserId(0);
        vacation.setDateFrom("10.12.2022");
        vacation.setDateTo("15.12.2022");
        List<Vacation> vacations = new ArrayList<>();
        for (int i = 0; i<8; i++){
            Vacation vac = new Vacation();
            vac.setId(i+1);
            vac.setType(VacationType.PAID);
            vac.setUserId(0);
            vac.setDateFrom("10.0"+ (i+1) + ".2022");
            vac.setDateTo("20.0" + (i+1) + ".2022");
            vacations.add(vac);
        }
        int day = 28;
        Assert.assertFalse(analizVacations(vacation,vacations,day));
    }
    @Test
    public void testAnalizVacationsNewYear() {
        Vacation vacation = new Vacation();
        vacation.setId(0);
        vacation.setType(VacationType.PAID);
        vacation.setUserId(0);
        vacation.setDateFrom("10.12.2022");
        vacation.setDateTo("15.12.2022");
        List<Vacation> vacations = new ArrayList<>();
        for (int i = 0; i<8; i++){
            Vacation vac = new Vacation();
            vac.setId(i+1);
            vac.setType(VacationType.PAID);
            vac.setUserId(0);
            if (i == 5) {
                vac.setDateFrom("10.0"+ (i+1) + ".2021");
                vac.setDateTo("20.0" + (i+1) + ".2021");
            }
            else if(i==7||i==2){
                vac.setDateFrom("10.0"+ (i+1) + ".2020");
                vac.setDateTo("20.0" + (i+1) + ".2020");
            }else {
                vac.setDateFrom("10.0"+ (i+1) + ".2022");
                vac.setDateTo("20.0" + (i+1) + ".2022");
            }
            vacations.add(vac);
        }
        int day = 99;
        Assert.assertTrue(analizVacations(vacation,vacations,day));
    }

    @Test
    public void testAnalizVacationsEndNewYear() {
        Vacation vacation = new Vacation();
        vacation.setId(0);
        vacation.setType(VacationType.PAID);
        vacation.setUserId(0);
        vacation.setDateFrom("02.12.2022");
        vacation.setDateTo("29.12.2022");
        List<Vacation> vacations = new ArrayList<>();
        for (int i = 0; i<1; i++){
            Vacation vac = new Vacation();
            vac.setId(i+1);
            vac.setType(VacationType.PAID);
            vac.setUserId(0);
            vac.setDateFrom("29.12.2021");
            vac.setDateTo("01.0" + (i+1) + ".2022");
            vacations.add(vac);
        }
        int day = 34;
        Assert.assertTrue(analizVacations(vacation,vacations,day));
    }
    @Test
    public void testAnalizVacationsMax() {
        Vacation vacation = new Vacation();
        vacation.setId(0);
        vacation.setType(VacationType.PAID);
        vacation.setUserId(0);
        vacation.setDateFrom("10.12.2022");
        vacation.setDateTo("18.12.2022");
        // 2022 - 9
        List<Vacation> vacations = new ArrayList<>();
        for (int i = 0; i<4; i++){
            Vacation vac = new Vacation();
            vac.setId(i+1);
            vac.setType(VacationType.PAID);
            vac.setUserId(0);
            if (i == 1) {
                vac.setDateFrom("01.01.2021");
                vac.setDateTo("24.01.2021");
                // 2021 - 28
            }
            else if(i==2){
                vac.setDateFrom("02.01.2020");
                vac.setDateTo("29.01.2020");
                // 2020 - 28
            }
            else if(i==0){
                vac.setDateFrom("28.12.2021");
                vac.setDateTo("05.01.2022");
                // 2021 - 4
                // 2022 - 5
            }
            else {
                vac.setDateFrom("01.01.2022");
                vac.setDateTo("2.01.2022");
                // 2022 - 2
            }
            vacations.add(vac);
        }
        int day = 28;
        Assert.assertTrue(analizVacations(vacation,vacations,day));
    }
    @Test
    public void testAnalizVacations1() {
        Vacation vacation = new Vacation();
        vacation.setId(0);
        vacation.setType(VacationType.PAID);
        vacation.setUserId(0);
        vacation.setDateFrom("10.12.2022");
        vacation.setDateTo("18.12.2022");
        // 2022 - 9
        List<Vacation> vacations = new ArrayList<>();
            Vacation vac = new Vacation();
            vac.setId(1);
            vac.setType(VacationType.PAID);
            vac.setUserId(0);
                vac.setDateFrom("01.01.2022");
                vac.setDateTo("28.01.2022");
                // 2022 - 28
            vacations.add(vac);
            // должно быть 37
        int day = 28;
        Assert.assertFalse(analizVacations(vacation,vacations,day));
    }
    @Test
    public void testAnalizVacations3() {
        Vacation vacation = new Vacation();
        vacation.setId(0);
        vacation.setType(VacationType.PAID);
        vacation.setUserId(0);
        vacation.setDateFrom("25.12.2021");
        vacation.setDateTo("09.01.2022");
        // 2021 - 7
        // 2022 - 9
        List<Vacation> vacations = new ArrayList<>();
        Vacation vac = new Vacation();
        vac.setId(1);
        vac.setType(VacationType.PAID);
        vac.setUserId(0);
        vac.setDateFrom("01.01.2022");
        vac.setDateTo("28.01.2022");
        // 2022 - 28
        vacations.add(vac);
        // должно быть 37
        int day = 38;
        Assert.assertTrue(analizVacations(vacation,vacations,day));
    }
    @Test
    public void testAnalizVacations4() {
        Vacation vacation = new Vacation();
        vacation.setId(0);
        vacation.setType(VacationType.PAID);
        vacation.setUserId(0);
        vacation.setDateFrom("25.12.2021");
        vacation.setDateTo("09.01.2022");
        // 2021 - 7
        // 2022 - 9
        List<Vacation> vacations = new ArrayList<>();
        Vacation vac = new Vacation();
        vac.setId(1);
        vac.setType(VacationType.PAID);
        vac.setUserId(0);
        vac.setDateFrom("01.01.2022");
        vac.setDateTo("28.01.2022");
        // 2022 - 28
        vacations.add(vac);
        // должно быть 37
        int day = 28;
        Assert.assertFalse(analizVacations(vacation,vacations,day));
    }
}