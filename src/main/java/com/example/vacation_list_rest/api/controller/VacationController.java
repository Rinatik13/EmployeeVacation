package com.example.vacation_list_rest.api.controller;

import com.example.vacation_list_rest.api.entity.Vacation;
import com.example.vacation_list_rest.api.service.vacation.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacation")
public class VacationController {
    @Autowired
    VacationService vacationService;

    @GetMapping("/all")
    public List<Vacation> getAllVacation(){
        return vacationService.getAll();
    }

    @PostMapping("/add")
    public Vacation addVacation(@RequestBody Vacation vacation){
        return vacationService.addVacation(vacation);
    }

    @PostMapping("/edit")
    public Vacation editVacation(@RequestBody Vacation vacation){
        return vacationService.editVacation(vacation);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        vacationService.delete(id);
    }
}
