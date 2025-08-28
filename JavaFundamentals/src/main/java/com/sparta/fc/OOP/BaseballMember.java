package com.sparta.fc.OOP;

public class BaseballMember extends Member{

    private String position;

    public BaseballMember(String firstName, String lastName, int year, int month, int day, String position) {
        super(firstName, lastName, year, month, day);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // inheriting the super-class's method but overriding it
    @Override
    public String toString(){
        return super.toString() + " and is a " + this.getPosition();
    }

}
