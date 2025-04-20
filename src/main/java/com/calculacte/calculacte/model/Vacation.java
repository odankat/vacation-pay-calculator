package com.calculacte.calculacte.model;

import java.time.LocalDate;
import java.util.Objects;

public class Vacation {
    private int salary;
    private int day;
    private LocalDate startDate;
    private LocalDate endDate;

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Vacation(int salary, LocalDate startDate, LocalDate endDate) {
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Vacation(int salary, int day) {
        this.salary = salary;
        this.day = day;
    }

    public Vacation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return Double.compare(salary, vacation.salary) == 0 && day == vacation.day && Objects.equals(startDate, vacation.startDate) && Objects.equals(endDate, vacation.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, day, startDate, endDate);
    }


}
