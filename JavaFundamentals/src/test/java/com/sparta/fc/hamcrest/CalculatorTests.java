package com.sparta.fc.hamcrest;

import org.hamcrest.MatcherAssert.*;
import org.hamcrest.Matchers.*;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Assertions;import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CalculatorTests {


    @Test
    void given2And6_Add_Returns8Pt0() {
        Calculator calc = new Calculator(6, 2);

        assertThat(calc.add(), is(8.0));
    }
    @Test
    void given6And3_DivisibleBy_ReturnsTrue() {
        Calculator calc = new Calculator(6, 2);

        assertThat(calc.divisibleBy(), is(true));
    }
    @Test
    void given7And3_DivisibleBy_ReturnsFalse() {
        Calculator calc = new Calculator(7, 3);

        assertThat(calc.divisibleBy(), is(false));
    }
    @Test
    void given7And3_ToString_OutputContainsCalculator() {
        Calculator calc = new Calculator(7, 3);

        assertThat(calc.toString(), containsString("Calculator"));
    }

    @Test
    void moreStringMatchers(){
        String testString = "The quick brown fox jumps over the lazy dog.";
        assertThat(testString, startsWith("The"));
        assertThat(testString, containsStringIgnoringCase("the"));
        assertThat(testString, stringContainsInOrder("quick", "jump", "lazy"));
        assertThat(testString, not(emptyOrNullString()));
    }

    @Test
    void collectionMatchersExercise(){
        List<String> fruit = List.of(
                "apple", "pear", "banana", "peach", "pomegranate", "pineapple", "lemon"
        );
        assertThat(fruit.size(), is(7));
        assertThat(fruit, containsInRelativeOrder("apple", "banana", "pomegranate", "lemon"));
        assertThat(fruit, hasItems("banana", "pear"));
        assertThat(fruit, containsInAnyOrder("lemon", "pineapple", "pomegranate", "apple", "peach", "pear", "banana"));
        assertThat(fruit, not(hasItem("grape")));
        assertThat(fruit, not(hasItem(endsWith("z"))));

    }
}
