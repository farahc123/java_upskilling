package com.sparta.fc.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AnimalTests {

    @ParameterizedTest
    @DisplayName("given an age of 0 or above, setAge() changes the age")
    @CsvSource({
        "0,0", // new, expected
        "10, 10" // new, expected
    })
    public void setAgeHappyPath(int newAge, int expectedAge){
        Animal sut = new Animal();
        sut.setAge(newAge);
        Assertions.assertEquals(expectedAge, sut.getAge());

    }

    @Test
    @DisplayName("given an age below 0, setAge() throws an IllegalArgument exception")
    public void setAgeSadPath(){
        Animal sut = new Animal();

        // invoke a method and return anything it throws
        // we then store it in the exception variable
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sut.setAge(-2));
    }

    @ParameterizedTest
    @DisplayName("given a name, setName() changes the name")
    @CsvSource({
            "Rover,Rover", // new, expected
            "Charlie, Charlie" // new, expected
    })
    public void setNameHappyPath(String newName, String expectedName){
        Animal sut = new Animal();
        sut.setName(newName);
        Assertions.assertEquals(expectedName, newName);
    }

    @Test
    @DisplayName("given a null name, setName() throws a NullPointerException")
    public void setNameSadPath(){
        Animal sut = new Animal();

        // invoke a method and return anything it throws
        // we then store it in the exception variable
        var exception = Assertions.assertThrows(NullPointerException.class, () -> sut.setName(null));
    }

}
