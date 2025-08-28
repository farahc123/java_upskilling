package com.sparta.fc.OOP;

import com.sparta.fc.OOP.exercise.Animal;
import com.sparta.fc.OOP.exercise.Bird;
import com.sparta.fc.OOP.exercise.Cat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BirdTests {

    // class methods to test: getName(); setName(); getAge(); toString(); speak();

    @Test
    @DisplayName("getName returns the correct name")
    public void getNameTest() {

        Animal sut = new Bird("Tweetie", 2022, 1, 1);

        String result = sut.getName();

        Assertions.assertEquals("Tweetie", result);
    }

    @Test
    @DisplayName("setName returns the correct new name")
    public void setNameTest() {

        Animal sut = new Bird("Tweetie", 2022, 1, 1);

        sut.setName("Zazu");

        String result = sut.getName();

        Assertions.assertEquals("Zazu", result);
    }

    @Test
    @DisplayName("getAge returns the correct age")
    public void getAgeTest() {

        Animal sut = new Bird("Tweetie", 2022, 1, 1);

        int result = sut.getAge();

        Assertions.assertEquals(3, result);
    }

    @Test
    @DisplayName("toString returns the correct string")
    public void toStringTest() {

        Animal sut = new Bird("Tweetie", 2022, 1, 1);

        String result = sut.toString();

        Assertions.assertEquals("Tweetie is 3 years old and says squawk", result);
    }

    @Test
    @DisplayName("speak returns the correct string")
    public void speakTest() {

        Animal sut = new Bird("Tweetie", 2022, 1, 1);

        String result = sut.speak();

        Assertions.assertEquals("squawk", result);
    }
}
