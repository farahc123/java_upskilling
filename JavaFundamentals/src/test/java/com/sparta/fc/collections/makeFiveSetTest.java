package com.sparta.fc.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static com.sparta.fc.collections.Lab.makeFiveSet;

public class makeFiveSetTest {

    @Test
    @DisplayName("makeFiveSetTest should return correct values")
    public void makeFiveSetTest(){
        HashSet<Integer> result = makeFiveSet(22);

        HashSet<Integer> expected = new HashSet<>();
        expected.add(20);
        expected.add(15);
        expected.add(10);
        expected.add(5);

        Assertions.assertEquals(expected, result);
    }

}
