package com.sparta.fc.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static com.sparta.fc.collections.Lab.longWordList;

public class longWordListTest {

    @Test
    @DisplayName("longWordListTest should return words of 5 or more characters")
    public void longWordListTest(){
        ArrayList<String> result = Lab.longWordList("The hippopotamus is eating grass");

        Assertions.assertTrue(result.contains("hippopotamus"));
        Assertions.assertTrue(result.contains("eating"));
        Assertions.assertTrue(result.contains("grass"));
        Assertions.assertFalse(result.contains("The"));
        Assertions.assertFalse(result.contains("is"));


    }

}
