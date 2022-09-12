package com.example.vacation_list_rest.api.controller;

import com.example.vacation_list_rest.api.entity.Vacation;
import com.example.vacation_list_rest.api.service.vacation.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/vacation")
public class VacationController {
    @Autowired
    private VacationService vacationService;

    @GetMapping("/all")
    public List<Vacation> getVacations(){
        return vacationService.getAll();
    }

    // доделать логику работы с входными параметрами id и body
    @PutMapping("/{id}")
    public Vacation addVacation(@RequestBody Vacation vacation, @PathVariable int id){
        return vacationService.addVacation(vacation);
    }

    @PatchMapping("/edit")
    public Vacation editVacation(@RequestBody Vacation vacation){
        return vacationService.editVacation(vacation);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        vacationService.delete(id);
    }

    @GetMapping("/{employeeId}/all")
    public List<Vacation> getEmployeeVacations(@PathVariable int employeeId){
        return vacationService.getEmployeeVacations(employeeId);
    }
}
