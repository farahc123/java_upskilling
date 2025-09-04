package com.sparta.fc.OOP;

import org.junit.jupiter.api.*;

public class MemberTests {

    @BeforeAll
    public static void beforeAll() { // runs once only, and all following test methods can use any variables defined here
        System.out.println("---before all");
    }

    @BeforeEach
    public void beforeEach() { // runs before each test method
        System.out.println("---before each");
    }

    @AfterEach
    public void afterEach() { // runs after each test method
        System.out.println("---after each");
    }

    @AfterAll
    public static void afterAll(){ // runs after all test methods have been run
        System.out.println("---after all");
    }

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
