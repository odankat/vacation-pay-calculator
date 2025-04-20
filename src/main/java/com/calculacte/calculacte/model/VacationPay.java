package com.calculacte.calculacte.model;

import java.util.Objects;

public class VacationPay {
    private double vacationPay;


    public VacationPay(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    public VacationPay() {

    }

    public double getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(double vacationPay) {
        double rounded = Math.round(vacationPay * 100) / 100.0;
        this.vacationPay = rounded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacationPay that = (VacationPay) o;
        return Double.compare(vacationPay, that.vacationPay) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacationPay);
    }
}
