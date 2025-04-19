package com.calculacte.calculacte.controller;

import com.calculacte.calculacte.model.Vacation;
import com.calculacte.calculacte.model.VacationPay;
import com.calculacte.calculacte.service.VacationCalculateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VacationController {
    private final VacationCalculateService vacationCalculateService;

    public VacationController(VacationCalculateService vacationCalculateService) {
        this.vacationCalculateService = vacationCalculateService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<VacationPay> calculateVacation(
            @RequestParam Integer salary,
            @RequestParam(required = false) Integer day,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
        return vacationCalculateService.checkInfo(salary, day, startDate, endDate);
    }

}
