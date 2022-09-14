package com.example.vacation_list_rest.api.service.vacation;

import com.example.vacation_list_rest.api.entity.Vacation;

import java.util.List;

public interface VacationService {
    public List<Vacation> getAll();
    public List<Vacation> getEmployeeVacations(int employeeId);
    public Vacation saveVacation(Vacation vacation);
    public Vacation editVacation(Vacation vacation, int id);
    public void delete(int id);
}
