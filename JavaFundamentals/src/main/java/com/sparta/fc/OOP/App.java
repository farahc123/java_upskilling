package com.sparta.fc.OOP;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        Member nish = new Member("Nish", "Mandal", 2022, 1, 1); // returns a member with these values
        Member farah = new Member("Farah", "Cheded", 2025, 5, 4);
        Member zainab = new Member("Zainab", "Farooq", 2024, 6, 17);
        System.out.println("--- Members and days:");
        System.out.println(farah.getFullName() + " has been a member for " + farah.getMemberDays() + " days");
        System.out.println(zainab.getFullName() + " has been a member for " + zainab.getMemberDays() + " days");
        System.out.println(nish.getFullName() + " has been a member for " + nish.getMemberDays() + " days");

        farah.setLastName("C");
        System.out.println("--- New name for farah object after using setter method:");
        System.out.println(farah.getFullName());
        System.out.println(farah.toString());

        System.out.println("--- Looping through the members and getting their full names:");
        Member[] members = {farah, zainab, nish};
        for (Member member : members) {
            System.out.println(member.getFullName());
        }

        Shape rectangle = new Rectangle(5, 2);
        System.out.println(rectangle);

        Shape circle = new Circle(3);
        System.out.println(circle);

        // benefit of OOP is that we can store both the Rectangle and Circle objects in a Shape array
        Shape[] shapes = {rectangle, circle};

        for(Shape shape: shapes){
            System.out.println(shape);
        }


    }
}

//  create a few more member objects
/// / print out their names, using the getter methods
/// / print out the days since they have joined
/// / create an array of member objects, loop through them, and get their full name