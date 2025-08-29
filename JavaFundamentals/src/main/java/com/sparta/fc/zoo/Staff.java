package com.sparta.fc.zoo;

import java.time.LocalDate;
import java.time.Period;

public abstract class Staff implements Speakable{

    private final String firstName;
    private String lastName;
    private final LocalDate joinDate;

    public Staff(String firstName, String lastName, int year, int month, int day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = LocalDate.of(year, month, day);
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String serviceLength(){
        LocalDate today = LocalDate.now();
        Period servicePeriod = Period.between(joinDate, today);

        return servicePeriod.getYears() + " years, " +
                servicePeriod.getMonths() + " months, " +
                servicePeriod.getDays() + " days";
    }

}
