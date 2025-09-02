package com.sparta.fc.SOLID.bird.good;

// ---------------- ISP: Each class/interface has one responsibility and can be cherry-picked ----------------
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

// ---------------- SRP & LSP: Subtypes can be used interchangeably and class only has single responsibility ----------------
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
class FlyerWatcher {
    private Flyer flyer;

    public FlyerWatcher(Flyer flyer) {  // depends on abstraction
        this.flyer = flyer;
    }

    public void watchFlying() {
        flyer.fly();
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
