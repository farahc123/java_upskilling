package com.sparta.fc.streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.logging.*;

public class App {


    public static void main(String[] args) {


        Dog dog1 = new Dog("Rover");
        Dog dog2 = new Dog("Charlie");
        Bird bird1 = new Bird("Tweetie");
        Bird bird2 = new Bird("Zazu");
        Bird bird3 = new Bird("Zazu");


//        // creating list of animals
//        List<Animal> animals = new ArrayList<>(List.of(dog1, dog2, bird1, bird2, bird3));
//
//        // creating set of flyable aniamls (no duplicates
//        Set<Flyable> flyables = new HashSet<>();
//        for (Animal animal : animals) {
//            if (animal instanceof Flyable) {
//                flyables.add((Flyable) animal); // cast to Flyable and add to the set
//            }
//        }
//
//        System.out.println("-----No duplicates in set:");
//        for (Flyable f : flyables) {
//            System.out.println(f.fly());
//        }
//
//        // creating map of name: animal object
//        Map<String, Animal> animalMap = new HashMap<>();
//
//        animalMap.put(dog1.getName(), dog1);
//        animalMap.put(dog2.getName(), dog2);
//        animalMap.put(bird1.getName(), bird1);
//        animalMap.put(bird2.getName(), bird2);
//        animalMap.put(bird3.getName(), bird3);
//
//        System.out.println("-----Testing map:");
//        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        // using streams
//
//        // beatles.stream()
//        //                .filter(App::startsWithJ) // assuming I've created a startsWithJ method and I'm in an App class
//        //                .forEach(name -> System.out.println(name));
//
//        System.out.println("-----Using streams and lambda expressions to filter bird class objects: ");
//        animals.stream().filter(a -> a.getClass().getName().contains("Bird")).forEach(System.out::println);
//
//        System.out.println("-----Using streams to collect list of animal names: ");
//        List<String> animalNamesStreamList = animals.stream().map(Animal::getName).collect(Collectors.toList());
//        System.out.println(animalNamesStreamList);
//
//
    }
}

