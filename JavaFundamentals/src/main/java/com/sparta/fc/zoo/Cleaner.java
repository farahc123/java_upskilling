package com.sparta.fc.zoo;

public class Cleaner extends Staff {

    public Cleaner(String firstName, String lastName, int year, int month, int day) {
        super(firstName, lastName, year, month, day);
    }

    public String cleanZoo(){
        return this.getFirstName() + this.getLastName() + "is cleaning the zoo";
    }

    @Override
    public String speak(){
        return "Hello, I'm " + this.getFirstName() + ", your cleaner!";
    }
}
