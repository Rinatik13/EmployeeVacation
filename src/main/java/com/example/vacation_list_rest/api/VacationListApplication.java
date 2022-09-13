package com.example.vacation_list_rest.api;

import com.example.vacation_list_rest.api.entity.Vacation;
import com.example.vacation_list_rest.api.entity.VacationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VacationListApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacationListApplication.class, args);
	}

}
