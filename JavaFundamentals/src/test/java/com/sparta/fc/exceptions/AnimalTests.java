package com.sparta.fc.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;

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
    @DisplayName("given a date in dd-MM-yyyy, setVaccinationDate() sets the date")
    @CsvSource({
            "15-08-2022,15-08-2022", // new, expected
            "02-02-2023,02-02-2023"  // new, expected
    })
    public void setVaccinationDateHappyPath(String newDate, String expectedDate) throws ParseException {
        Animal sut = new Animal("Buddy", 3);
        sut.setVaccinationDate(newDate); // takes a string, and saves a SimpleDateFormat object

        // turning the newDate date object into a string so it can be compared to the string passed in CsvSource as the expected value
        String newDateConverted = new java.text.SimpleDateFormat("dd-MM-yyyy")
                .format(sut.getVaccinationDate());

        Assertions.assertEquals(expectedDate, newDateConverted);
    }

    @Test
    @DisplayName("given an invalid date, setVaccinationDate() throws ParseException")
    public void setVaccinationDateSadPath(){
        Animal cat = new Animal("Whiskers", 2);

        // invoke a method and return anything it throws
        var exception = Assertions.assertThrows(ParseException.class, () -> cat.setVaccinationDate("August 15, 2022"));
    }

    @ParameterizedTest
    @DisplayName("given a name, setName() changes the name")
    @CsvSource({
            "Rover, ROVER", // new, expected
            "Charlie,CHARLIE" // new, expected
    })
    public void setNameHappyPath(String newName, String expectedName){
         Animal sut = new Animal();
         sut.setName(newName);
         Assertions.assertEquals(expectedName, sut.getName());
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
