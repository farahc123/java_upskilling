package com.sparta.fc.streams;

public class Bird extends Animal implements Walkable, Flyable {
    public Bird(String name) {
        super(name);
    }


    @Override
    public String walk() {
        return "The bird is walking";
    }
    @Override
    public String fly() {
        return "The bird " + getName() + " is flying";
    }
}
