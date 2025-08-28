package com.sparta.fc.OOP.exercise;

public class App {
    public static void main(String[] args) {
        Animal firstCat = new Cat("Garfield", 2022, 11, 3, "lasagne");
        Animal secondCat = new Cat("Whiskers", 2024, 7, 11, "pizza");

        Animal firstBird = new Bird("Tweetie", 2022, 1, 1);
        Animal secondBird = new Bird("Zazu", 2003, 4, 2);

        Animal[] pets = {firstCat, secondCat, firstBird, secondBird};

        for(Animal pet: pets){
            System.out.println("--" + pet.toString());
            System.out.println(pet.speak());
        }
    }

}
