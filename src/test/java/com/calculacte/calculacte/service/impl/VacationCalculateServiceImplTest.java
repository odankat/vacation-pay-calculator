package com.calculacte.calculacte.service.impl;

import com.calculacte.calculacte.model.Vacation;
import com.calculacte.calculacte.model.VacationPay;
import com.calculacte.calculacte.service.VacationCalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VacationCalculateServiceImplTest {
    private final int WORKING_DAYS = 22;

    @Test
    void calculateByDays() {
        //given
        Vacation vacation = new Vacation(10000, 10);
        VacationPay vacationPay = new VacationPay();

        //when
        double test = (vacation.getSalary() / WORKING_DAYS) * vacation.getDay();
        vacationPay.setVacationPay(test);
        double expected = vacationPay.getVacationPay();
        double actual = new VacationCalculateServiceImpl().calculateByDays(vacation).getBody().getVacationPay();

        //then
        Assertions.assertEquals(expected, actual);


    }
}