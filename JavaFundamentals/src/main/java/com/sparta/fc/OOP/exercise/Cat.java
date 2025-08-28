package com.sparta.fc.OOP.exercise;

public class Cat extends Animal {

    private String favouriteFood;

    public Cat(String name, int year, int month, int day, String favouriteFood) {
        super(name, year, month, day);
        this.favouriteFood = favouriteFood;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    @Override
    public String speak() {
        return "meow";
    }

    @Override
    public String toString(){
        return super.toString() + " and has a favourite food of " + this.getFavouriteFood();
    }
}
