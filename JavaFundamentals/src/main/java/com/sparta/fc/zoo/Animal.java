package com.sparta.fc.zoo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Animal implements Speakable{

    private final String name;
    private final LocalDate birthdate;

    public Animal(String name, int year, int month, int day) {
        this.name = name;
        this.birthdate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period age = Period.between(birthdate, now);
        int yearAge = age.getYears();
        return yearAge;
    }
}