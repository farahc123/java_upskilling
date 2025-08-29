package com.sparta.fc.OOP.exercise;

public class App {
    public static void main(String[] args) {
        Animal cat1 = new Cat("Garfield", 2022, 11, 3, "lasagne");
        Animal cat2 = new Cat("Whiskers", 2024, 7, 11, "pizza");

        Animal bird1 = new Bird("Tweetie", 2022, 1, 1);
        Animal bird2 = new Bird("Zazu", 2003, 4, 2);

        Animal[] pets = {cat1, cat2, bird1, bird2};

        for(Animal pet: pets){
            System.out.println("--" + pet.toString());
            System.out.println(pet.speak());
        }

        Animal bird3 = new Bird("Zazu", 2003, 4, 2); // same args as bird2

        System.out.println(bird2.equals(bird3)); // returns true because the equals() method has been overridden to compare values of the class's parameters
        System.out.println(bird2.hashCode()); // outputs same hashcode as below because the hashCode() method has been overridden to hash the values of the parameters provided, which are the same for these two objects
        System.out.println(bird3.hashCode()); // outputs same hashcode as above
    }

}
