package com.sparta.fc.SOLID.bird.bad;

// Violates **ISP**: clients forced to use methods they don't need
interface Animal {
    void eat();
    void fly();
    void swim();
}

class Bird implements Animal{
    public String name;

    public Bird(String name) {
        this.name = name;
    }

    // Single class does way too much → Violates **SRP**
    public void fly() {
        System.out.println(name + " is flying");
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    // Violates **LSP**: Imagine we extend Bird for Penguin
    // Penguin cannot fly, so replacing Bird with Penguin would break fly()
    public void swim() {
        System.out.println(name + " swims");
    }

    // Violates **OCP**: adding new behavior requires changing this class
    public void makeSound(String type) {
        if (type.equals("chirp")) {
            System.out.println(name + " chirps");
        } else if (type.equals("squawk")) {
            System.out.println(name + " squawks");
        }
    }
}

// Violates **DIP**: High-level class depends directly on low-level implementation
class BirdWatcher {
    private Bird bird;

    public BirdWatcher(Bird bird) {
        this.bird = bird;
    }

    public void watch() {
        bird.fly(); // directly depends on concrete Bird
    }
}
