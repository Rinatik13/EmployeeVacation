package com.example.vacation_list_rest.api.logic;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


public class VacationDayCount {

    // возвращаем количество дней отпуска
    public int getVacationDay(String dateStart, String dateEnd) {
        Calendar calendarStart = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        int countDay = 0;
        try {
            calendarStart.setTime(sdf.parse(dateStart));
            calendarEnd.setTime(sdf.parse(dateEnd));

            while (!calendarStart.after(calendarEnd)) {
                calendarStart.add(Calendar.DAY_OF_WEEK,1);
                countDay++;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return countDay;
    }

    // возвращаем количество дней привязанных к конкретному году. перебираем срок начала и конца отпуска.
    // ключём служит год, значение это количество отпусков забронированных в этом году.
    public Map<String,Integer> getVacationYearDay(String dateStart, String dateEnd) {
        Calendar calendarStart = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdfYaer = new SimpleDateFormat("yyyy");
        Map<String,Integer> countDayToYear = new HashMap<>();
        try {
            calendarStart.setTime(sdf.parse(dateStart));
            calendarEnd.setTime(sdf.parse(dateEnd));
            // создаём карту годов с количеством дней
            while (!calendarStart.after(calendarEnd)){
                String year = sdfYaer.format(calendarStart.getTime());
                countDayToYear.put(year,0);
                calendarStart.add(Calendar.YEAR,1);
            }
            String endYear = sdfYaer.format(calendarEnd.getTime());
            countDayToYear.put(endYear,0);
            calendarStart.setTime(sdf.parse(dateStart));

            // перебираем дни от начала до конца
            // будем вытаскивать года и добавлять в нашу карту
            while (!calendarStart.after(calendarEnd)) {
                String year = sdfYaer.format(calendarStart.getTime());
                countDayToYear.put(year,countDayToYear.get(year)+1);
                calendarStart.add(Calendar.DAY_OF_WEEK,1);
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return countDayToYear;
    }
}
