package com.sparta.fc.OOP;

public class Rectangle extends Shape{

    private int length;
    private int width;

    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    @Override
    public int calculateArea() {
        return width * length;
    }

    @Override
    public String print() {
        return "I am a rectangle";
    }

    // this class also inherits the toString() method of the Shape class
}

