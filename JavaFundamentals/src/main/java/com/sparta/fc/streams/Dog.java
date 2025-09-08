package com.sparta.fc.streams;

public class Dog extends Animal implements Walkable{

    public Dog(String name) {
        super(name);
    }
    @Override
    public String walk() {
        return "The dog " + getName() + " is walking";
    }
}
