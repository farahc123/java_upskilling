package com.sparta.fc.OOP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTests {

    @Test
    @DisplayName("getFirstName returns the correct name")
    public void getFirstNameTest() {
        // arrange -- we need to create an object here as the methods tested are not static
        Member sut = new Member("Nish", "Mandal", 2015, 8, 3);

        // act
        String result = sut.getFirstName();

        // assert
        Assertions.assertEquals("Nish Mandal", result);

    }

    @Test
    @DisplayName("getFullName returns the correct name")
    public void getFullNameTest() {
        // arrange -- we need to create an object here as the methods tested are not static
        Member sut = new Member("Nish", "Mandal", 2015, 8, 3);

        // act
        String result = sut.getFullName();

        // assert
        Assertions.assertEquals("Nish Mandal", result);

    }
}
