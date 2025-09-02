package com.sparta.fc.generics;

public class App {

    public static void main(String[] args) {

        // type-specific
        IntegerRectangle iRect = new IntegerRectangle(2, 4);
        System.out.println("iRect height: " + iRect.getHeight());
        System.out.println("iRect width: " + iRect.getWidth());

        // generic
        GenericRectangle<Integer> giRect = new GenericRectangle<>(2, 4);
        GenericRectangle<Double> gdRect = new GenericRectangle<>(2.0, 4.0);
    /*
    this wouldn't compile as it's not a number:

    GenericRectangle<String> siRect = new GenericRectangle<>("2", "4");
     */

    }
}
