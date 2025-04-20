package com.calculacte.calculacte.service.impl;

import com.calculacte.calculacte.model.Vacation;
import com.calculacte.calculacte.model.VacationPay;
import com.calculacte.calculacte.service.VacationCalculateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class VacationCalculateServiceImpl implements VacationCalculateService {
    private final int WORKING_DAYS = 22;

    @Override
    public ResponseEntity<VacationPay> checkInfo(Integer salary, Integer day, LocalDate startDate, LocalDate endDate) {
        validateInput(salary, day, startDate, endDate);
        if (startDate != null) {
            Vacation vacation = new Vacation(salary, startDate, endDate);
            return calculateByDates(vacation);
        } else {
            Vacation vacation = new Vacation(salary, day);
            return calculateByDays(vacation);
        }
    }

    private void validateInput(Integer salary, Integer day, LocalDate startDate, LocalDate endDate) {
        if (day == null && (startDate == null || endDate == null)) {
            throw new IllegalArgumentException("specify either the number of days or both startDate and endDate");
        }
        if (salary == null || salary < 0) {
            throw new IllegalArgumentException("salary is indicated incorrectly");
        }

    }

    public ResponseEntity<VacationPay> calculateByDates(Vacation vacation) {
        if (vacation.getEndDate().isBefore(vacation.getStartDate())) {
            throw new IllegalArgumentException("vacation dates are incorrect");
        }
        Set<LocalDate> holidays = getHolidays(vacation.getStartDate().getYear());
        int workDay = 0;
        LocalDate date = vacation.getStartDate();
        while (!date.isAfter(vacation.getEndDate())) {
            if (!holidays.contains(date)) {
                workDay++;
            }
            date = date.plusDays(1);
        }
        VacationPay vacationPay = new VacationPay();
        vacationPay.setVacationPay((vacation.getSalary() / WORKING_DAYS) * workDay);
        return ResponseEntity.ok(vacationPay);
    }

    public ResponseEntity<VacationPay> calculateByDays(Vacation vacation) {
        VacationPay vacationPay = new VacationPay();
        vacationPay.setVacationPay((vacation.getSalary() / WORKING_DAYS) * vacation.getDay());
        return ResponseEntity.ok(vacationPay);
    }

    private Set<LocalDate> getHolidays(int year) {
        Set<LocalDate> holidays = new HashSet<>();
        holidays.add(LocalDate.of(year, 1, 1));
        holidays.add(LocalDate.of(year, 1, 2));
        holidays.add(LocalDate.of(year, 1, 3));
        holidays.add(LocalDate.of(year, 1, 4));
        holidays.add(LocalDate.of(year, 1, 5));
        holidays.add(LocalDate.of(year, 1, 6));
        holidays.add(LocalDate.of(year, 1, 7));
        holidays.add(LocalDate.of(year, 1, 8));
        holidays.add(LocalDate.of(year, 2, 23));
        holidays.add(LocalDate.of(year, 3, 8));
        holidays.add(LocalDate.of(year, 5, 1));
        holidays.add(LocalDate.of(year, 5, 9));
        holidays.add(LocalDate.of(year, 6, 12));
        holidays.add(LocalDate.of(year, 11, 4));
        return holidays;
    }


}