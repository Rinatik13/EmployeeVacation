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
        // ������ ����� ��������� 88
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
        // ������ ����� ��������� 88
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
        // ������ ����� ��������� 88
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
            vac.setDateFrom("29.1"+ (i+1) + ".2021");
            vac.setDateTo("10.0" + (i+1) + ".2022");
            vacations.add(vac);
        }
        // ������ ����� ��������� 10!!!!
        int day = 34;
        Assert.assertTrue(analizVacations(vacation,vacations,day));
    }
}