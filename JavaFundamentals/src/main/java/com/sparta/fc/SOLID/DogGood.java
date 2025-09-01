package com.sparta.fc.SOLID;

class DogGood implements Eater, Swimmer {
    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    @Override
    public void swim() {
        System.out.println("Dog swims");
    }
}