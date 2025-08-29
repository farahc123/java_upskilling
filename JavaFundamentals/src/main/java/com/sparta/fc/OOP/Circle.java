package com.sparta.fc.OOP;
public class Circle extends Shape {
    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public int calculateArea() {
        return (int) (Math.PI * radius * radius);
    }

    @Override
    public String print() {
        return "I am a circle";
    }

    // this class also inherits the toString() method of the Shape class
}
