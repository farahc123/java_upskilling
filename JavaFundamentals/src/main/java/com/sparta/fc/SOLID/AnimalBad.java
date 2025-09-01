package com.sparta.fc.SOLID;

public interface AnimalBad {
    void eat();
    void fly();
    void swim();
}

class Dog implements AnimalBad {
    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    @Override
    public void fly() {
    }

    @Override
    public void swim() {
        System.out.println("Dog swims");
    }
}
