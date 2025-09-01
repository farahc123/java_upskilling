package com.sparta.fc.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.sparta.fc.collections.Lab.countDigitsInString;

public class countDigitsInStringTest {

    @Test
    @DisplayName("countDigitsInString returns correct count")
    public void countDigitsInStringTest(){
        String input = "a1233bx";

        HashMap<Character, Integer> expected = new HashMap<>();
        expected.put('1', 1);
        expected.put('2', 1);
        expected.put('3', 2);

        HashMap<Character, Integer> result = countDigitsInString("a1233bx");
        Assertions.assertEquals(expected, result);

    }
}
