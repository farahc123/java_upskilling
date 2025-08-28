package com.sparta.fc.OOP.exercise;

public class Bird extends Animal {

    public Bird(String name, int year, int month, int day) {
        super(name, year, month, day);
    }

    @Override
    public String speak() {
        return "squawk";
    }

    @Override
    public String toString(){
        return super.toString() + " and says " + this.speak();
    }
}
