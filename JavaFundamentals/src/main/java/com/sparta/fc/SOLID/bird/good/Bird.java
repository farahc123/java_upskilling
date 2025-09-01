package com.sparta.fc.SOLID.bird.good;

// ---------------- SRP & ISP: Each class/interface has one responsibility and can be cherry-picked ----------------
interface Eater {
    void eat();
}

interface Flyer {
    void fly();
}

interface Swimmer {
    void swim();
}

interface SoundMaker {
    void makeSound();
}

// ---------------- LSP: Subtypes can be used interchangeably ----------------
class Bird implements Eater, Flyer, SoundMaker {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps");
    }
}

class Penguin implements Eater, Swimmer, SoundMaker {
    private String name;

    public Penguin(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void swim() {
        System.out.println(name + " swims");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " squawks");
    }
}

// ---------------- DIP: Depend on abstractions, not concrete classes ----------------
class AnimalWatcher {
    private Eater eater;

    public AnimalWatcher(Eater eater) {  // depends on abstraction
        this.eater = eater;
    }

    public void watchEating() {
        eater.eat();
    }
}

// ---------------- OCP: Open for extension, closed for modification ----------------
class SoundDecorator implements SoundMaker {
    private SoundMaker animal;
    private String extraSound;

    public SoundDecorator(SoundMaker animal, String extraSound) {
        this.animal = animal;
        this.extraSound = extraSound;
    }

    @Override
    public void makeSound() {
        animal.makeSound();
        System.out.println(extraSound); // extend behavior without modifying original class
    }
}
