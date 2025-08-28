package com.sparta.fc.OOP;

import com.sparta.fc.OOP.exercise.Animal;
import com.sparta.fc.OOP.exercise.Cat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnimalTests {

    // class methods to test: getName(); setName(); getAge(); toString(); speak();

    @Test
    @DisplayName("getName returns the correct name")
    public void getNameTest() {

        Animal sut = new Cat("Whiskers", 2022, 1, 1, "tuna");

        String result = sut.getName();

        Assertions.assertEquals("Whiskers", result);
    }

    @Test
    @DisplayName("setName returns the correct new name")
    public void setNameTest() {

        Animal sut = new Cat("Whiskers", 2022, 1, 1, "tuna");

        sut.setName("Garfield");

        String result = sut.getName();

        Assertions.assertEquals("Garfield", result);
    }

    @Test
    @DisplayName("getAge returns the correct age")
    public void getAgeTest() {

        Animal sut = new Cat("Whiskers", 2022, 11, 1, "tuna");

        int result = sut.getAge();

        Assertions.assertEquals(2, result);
    }

    @Test
    @DisplayName("toString returns the correct string")
    public void toStringTest() {

        Animal sut = new Cat("Whiskers", 2022, 11, 1, "tuna");

        String result = sut.toString();

        Assertions.assertEquals("Whiskers is 2 years old and has a favourite food of tuna", result);
    }

    @Test
    @DisplayName("speak returns the correct string")
    public void speakTest() {

        Animal sut = new Cat("Whiskers", 2022, 11, 1, "tuna");

        String result = sut.speak();

        Assertions.assertEquals("meow", result);
    }

    // bird tests



}
