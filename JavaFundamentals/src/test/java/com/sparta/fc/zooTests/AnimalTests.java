package com.sparta.fc.zooTests;

import com.sparta.fc.zoo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AnimalTests {

    @Test
    @DisplayName("getName returns animals' names")
    public void getNamesTest() {
        Lion lion1 = new Lion("Fluffy", 2025, 1, 1, "chicken");
        Chimpanzee chimpanzee1 = new Chimpanzee("George", 2022, 1, 1, "rattle");


        Assertions.assertEquals("Fluffy", lion1.getName());
        Assertions.assertEquals("George", chimpanzee1.getName());
    }

    @Test
    @DisplayName("getBirthdate returns animals' birthdates")
    public void getBirthdatesTest() {
        Lion lion1 = new Lion("Fluffy", 2025, 1, 1, "chicken");
        Chimpanzee chimpanzee1 = new Chimpanzee("George", 2022, 1, 1, "rattle");

        Assertions.assertEquals(LocalDate.of(2025,1,1), lion1.getBirthdate());
        Assertions.assertEquals(LocalDate.of(2022,1,1), chimpanzee1.getBirthdate());
    }

    @Test
    @DisplayName("getAge returns animals' ages")
    public void getAgeTest() {
        Lion lion1 = new Lion("Fluffy", 2024, 1, 1, "chicken");
        Chimpanzee chimpanzee1 = new Chimpanzee("George", 2022, 1, 1, "rattle");

        Assertions.assertEquals(1, lion1.getAge());
        Assertions.assertEquals(3, chimpanzee1.getAge());
    }

    @Test
    @DisplayName("speak returns animals' noises")
    public void speakTest() {
        Chimpanzee chimpanzee1 = new Chimpanzee("George", 2022, 1, 1, "rattle");
        Lion lion1 = new Lion("Fluffy", 2024, 1, 1, "chicken");

        Assertions.assertEquals("roar", lion1.speak());
        Assertions.assertEquals("ooh ooh ah ah", chimpanzee1.speak());
    }


    // Chimpanzee tests

    @Test
    @DisplayName("getFavouriteToy returns chimpanzee's favourite toy")
    public void getFavouriteToyTest() {
        Chimpanzee chimpanzee1 = new Chimpanzee("George", 2022, 1, 1, "rattle");

        Assertions.assertEquals("rattle", chimpanzee1.getFavouriteToy());
    }

    @Test
    @DisplayName("setFavouriteToy modifies chimpanzee's favourite toy")
    public void setFavouriteToyTest() {
        Chimpanzee chimpanzee1 = new Chimpanzee("George", 2022, 1, 1, "rattle");

        chimpanzee1.setFavouriteToy("ball");

        Assertions.assertEquals("ball", chimpanzee1.getFavouriteToy());
    }


    // Lion test

    @Test
    @DisplayName("getFavouriteFood returns lion's favourite food")
    public void getFavouriteFoodTest() {
        Lion lion1 = new Lion("Fluffy", 2024, 1, 1, "chicken");

        Assertions.assertEquals("chicken", lion1.getFavouriteFood());
    }

    @Test
    @DisplayName("setFavouriteFood modifies lion's favourite food")
    public void setFavouriteFoodTest() {
        Lion lion1 = new Lion("Fluffy", 2024, 1, 1, "chicken");

        lion1.setFavouriteFood("beef");

        Assertions.assertEquals("beef", lion1.getFavouriteFood());
    }


}
