package com.sparta.fc.OOP.exercise;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animal animal)) return false;
        else{
            return Objects.equals(this.name, animal.name) && Objects.equals(this.birthdate, animal.birthdate);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate);
    }
}
