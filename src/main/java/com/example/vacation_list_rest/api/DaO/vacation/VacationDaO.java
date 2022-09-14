package com.example.vacation_list_rest.api.DaO.vacation;

import com.example.vacation_list_rest.api.entity.Vacation;

import java.util.List;

public interface VacationDaO {
    public List<Vacation> getAll();
    public Vacation addVacation(Vacation vacation);
    public void delete(int id);

    public Vacation getVacation(int id);

    public Vacation editVacation(Vacation vacation, int id);
}
