package com.sparta.nam.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

    public class FilmClassificationTests {
        @ParameterizedTest
        @ValueSource(ints = {0, 11})
        @DisplayName("getClassificationsByAge, when given an age from 0 to 11, returns U & PG films are available.")
        public void getClassificationsByAge_GivenAnAgeFrom0to11_ReturnsAppropriateFilms(int ageOfViewer){
            Assertions.assertEquals("U & PG films are available.", FilmClassification.getClassificationsByAge(ageOfViewer));
        }

        @ParameterizedTest
        @ValueSource(ints = {12, 14})
        @DisplayName("getClassificationsByAge, when given an age from 12 to 14, returns U, PG, & 12 films are available.")
        public void getClassificationsByAge_GivenAnAgeFrom12to14_ReturnsAppropriateFilms(int ageOfViewer){
            Assertions.assertEquals("U, PG, & 12 films are available.", FilmClassification.getClassificationsByAge(ageOfViewer));
        }

        @ParameterizedTest
        @ValueSource(ints = {15, 17})
        @DisplayName("getClassificationsByAge, when given an age from 15 to 17, returns U, PG, 12, & 15 films are available.")
        public void getClassificationsByAge_GivenAnAgeFrom15to17_ReturnsAppropriateFilms(int ageOfViewer){
            Assertions.assertEquals("U, PG, 12 & 15 films are available.", FilmClassification.getClassificationsByAge(ageOfViewer));
        }

        @ParameterizedTest
        @ValueSource(ints = {18})
        @DisplayName("getClassificationsByAge, when given an age from 18, returns All films are available.")
        public void getClassificationsByAge_GivenAnAgeFrom18_ReturnsAppropriateFilms(int ageOfViewer){
            Assertions.assertEquals("All films are available.", FilmClassification.getClassificationsByAge(ageOfViewer));
        }
}
