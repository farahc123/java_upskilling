package com.sparta.fc.collections;

import java.util.*;


public class Lab {

    public static HashSet<Integer> makeFiveSet(int max){
        HashSet<Integer> result = new HashSet<>();
        for(int i=1; i <= max; i ++){
            if(i % 5 == 0){
                result.add(i);
            }
        }
        return result;
    }

    public static ArrayList<String> longWordList(String phrase){
        String[] words = phrase.split("\\s,*");

        ArrayList<String> result = new ArrayList<>();
        for(String word: words){
            if (word.length()>=5){
                result.add(word);
            }
        }
        return result;
    }

    public static HashMap<Character, Integer> countDigitsInString(String phrase){
        HashMap<Character, Integer> digitCount = new HashMap<>(); // dictionary-like object

        for(char c: phrase.toCharArray()){ // turns phrase into array of characters and loops thru them
            if (Character.isDigit(c)){ // checks if the character is a digit
                if (digitCount.containsKey(c)){ // checks if character exists in map yet
                    digitCount.put(c, digitCount.get(c) + 1); // increments the count if it does
                }else{
                    digitCount.put(c, 1); // adds value to map and initialises it with 1
                }
            }
        }
        return digitCount;
    }
}
