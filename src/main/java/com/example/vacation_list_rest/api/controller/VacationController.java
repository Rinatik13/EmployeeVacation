package com.example.vacation_list_rest.api.controller;

import com.example.vacation_list_rest.api.entity.Vacation;
import com.example.vacation_list_rest.api.service.vacation.VacationService;
import com.example.vacation_list_rest.api.validation.DateValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacation")
public class VacationController {
    @Autowired
    private VacationService vacationService;

    @GetMapping("/all")
    public List<Vacation> getVacations(){
        return vacationService.getAll();
    }

    @PutMapping("")
    public Vacation addVacation(@RequestBody Vacation vacation){
        if (DateValid.validationDate(vacation.getDateFrom())&&DateValid.validationDate(vacation.getDateTo())){
            return vacationService.saveVacation(vacation);
        }
        else {
            return null;
        }
    }

    @PatchMapping("/{id}")
    public Vacation editVacation(@RequestBody Vacation vacation, @PathVariable int id){
        if (DateValid.validationDate(vacation.getDateFrom())&&DateValid.validationDate(vacation.getDateTo())){
            vacation.setId(id);
            return vacationService.saveVacation(vacation);
        }
        else {
            return null;
        }
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
