package com.sparta.fc.zoo;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Zookeeper zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");
        Cleaner cleaner1 = new Cleaner("John", "Roberts", 2020, 1, 1);
        Lion lion1 = new Lion("Fluffy", 2025, 1, 1, "chicken");
        Chimpanzee chimpanzee1 = new Chimpanzee("George", 2022, 1, 1, "rattle");

        ArrayList<Speakable> zooThings = new ArrayList<>();
        zooThings.add(zookeeper1);
        zooThings.add(cleaner1);
        zooThings.add(lion1);
        zooThings.add(chimpanzee1);

        for(Speakable x: zooThings){
            System.out.println(x.speak());

        }

        System.out.println(zookeeper1.speak());
        System.out.println(cleaner1.speak());





    }
}
