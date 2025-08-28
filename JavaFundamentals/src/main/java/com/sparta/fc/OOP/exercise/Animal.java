package com.sparta.fc.OOP.exercise;

import java.time.LocalDate;
import java.time.Period;

public abstract class Animal {
    private String name;
    private final LocalDate birthdate;

    public Animal(String name, int year, int month, int day) {
        this.name = name;
        this.birthdate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period age = Period.between(birthdate, now);
        int yearAge = age.getYears();
        return yearAge;
    }

    public String toString(){
        return this.getName() + " is " + this.getAge() + " years old";
    }

    public abstract String speak();

}
