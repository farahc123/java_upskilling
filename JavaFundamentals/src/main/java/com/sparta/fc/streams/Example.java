package com.sparta.fc.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Example {
    public static void main() {
        ArrayList<String> beatles = new ArrayList<>(List.of("John", "Paul", "George", "Ringo"));

        // imperative method (with a for loop)
        System.out.println("Using a for loop to loop thru all elements:");
        // getting all the Beatles whose name starts with J
        for(String beatle: beatles){
            if(beatle.startsWith("J")){
                System.out.println(beatle);
            }
        }

        // declarative method
        System.out.println("Using a stream to loop thru all elements:");
        // with streams
        beatles.stream().forEach(System.out::println);

        System.out.println("Using a stream to filter (i.e. iterate with an if condition) with a lambda expression");
        // filtering with streams
        beatles.stream()
                .filter(name -> name.startsWith("J"))
                .forEach(name -> System.out.println(name));


        // the above can be done like this too:
//        beatles.stream()
//                .filter(name -> name.startsWith("J"))
//                .forEach(System.out::println);


        System.out.println("Using a stream with another lambda expression");
        beatles.stream().filter(name -> name.startsWith("P")).forEach(name -> System.out.println(name.toUpperCase(Locale.ROOT)));


    System.out.println("Using a stream with map");
        List<String> upperNames = beatles.stream().map(name -> name.toUpperCase()).toList();
        System.out.println(upperNames);
    }

}
