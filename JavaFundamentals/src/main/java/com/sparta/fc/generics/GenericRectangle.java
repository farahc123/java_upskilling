package com.sparta.fc.generics;

public class GenericRectangle<E extends Number> {
    private E width;
    private E height;

    public GenericRectangle(E width, E height) {
        this.width = width;
        this.height = height;
    }

    public E getWidth() {
        return width;
    }

    public void setWidth(E width) {
        this.width = width;
    }

    public E getHeight() {
        return height;
    }

    public void setHeight(E height) {
        this.height = height;
    }

    // example of generic method
    static <E> void outputToConsole(E value){
        System.out.println(value);
    }
}
