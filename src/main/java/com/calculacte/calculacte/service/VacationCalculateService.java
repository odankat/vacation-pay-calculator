package com.calculacte.calculacte.service;

import com.calculacte.calculacte.model.VacationPay;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface VacationCalculateService {
    public ResponseEntity<VacationPay> checkInfo(Integer salary, Integer day, LocalDate startDate, LocalDate endDate);
}
