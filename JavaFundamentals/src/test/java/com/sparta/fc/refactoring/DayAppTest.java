package com.sparta.fc.refactoring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DayAppTest {

//    @Test
//    @DisplayName("My first test")
//    public void firstTest(){
//        Assertions.assertTrue(false);

    @Test
    @DisplayName("getGreeting, when given a time of 6, returns Good morning!")
    public void getGreeting_GivenATimeOf6_ReturnsGoodMorning() {
        // Arrange
        int time = 6;
        String expected = "Good morning!";

        // Act
        String actual = App.getGreeting(time);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getGreeting, when given a time of 14, returns Good afternoon!")
public void getGreeting_GiveATimeof14_ReturnsGoodAfternoon(){
        int time = 14;
        String expected = "Good afternoon!";
        String actual = App.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getGreeting, when given a time of 21, returns Good evening!")
    public void getGreeting_GivenATimeOf21_ReturnsGoodEvening() {
        // Arrange
        int time = 21;
        String expected = "Good evening!";

        // Act
        String actual = App.getGreeting(time);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 11})
    @DisplayName("getGreeting, when given a time from 5 to 11, returns Good morning!")
    public void getGreeting_GivenATimeFrom5To11_ReturnsGoodMorning(int time){
        Assertions.assertEquals("Good morning!", App.getGreeting(time));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 18})
    @DisplayName("getGreeting, when given a time from 12 to 18, returns Good afternoon!")
    public void getGreeting_GivenATimeFrom12To18_ReturnsGoodAfternoon(int time){
        Assertions.assertEquals("Good afternoon!", App.getGreeting(time));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 19, 23})
    @DisplayName("getGreeting, when given a time from 19 to 23, returns Good evening!")
    public void getGreeting_GivenATimeFrom19to23_ReturnsGoodEvening(int time){
        Assertions.assertEquals("Good evening!", App.getGreeting(time));
    }

    @ParameterizedTest
    @DisplayName("getGreeting, when given a time, returns an appropriate greeting")
    @CsvSource({
            "Good evening!, 2",
            "Good morning!, 8",
            "Good afternoon!, 15",
            "Good evening!, 21"
    })
    public void givenATime_Greeting_ReturnsAnaAppropriateGreeting(String expected, int time){
        Assertions.assertEquals(expected, App.getGreeting(time));
    }


}



