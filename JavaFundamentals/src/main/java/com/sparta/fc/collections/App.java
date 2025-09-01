package com.sparta.fc.collections;

import com.sparta.fc.OOP.Member;

import java.util.*;

import static com.sparta.fc.collections.Lab.*;

public class App {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>(); // you can also do ArrayList<String> nameList = etc... as it inherits from List interface
        nameList.add("Farah");
        nameList.add("Hannah");

        // initialising & adding directly
        // takes int and boxes it to Integer
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3)); // you can also do ArrayList<Integer> nums = etc... as it inherits from List interface
        for (var num : nums) { // unboxes into int
            System.out.println(num);
        }

        // alternative to the above that converts a normal array to an array list
        Integer[] ints = {1, 2, 3};
        System.out.println(ints.getClass());
        var arrList = Arrays.asList(ints); // converts to arraylist
        System.out.println(arrList.getClass());

        // AL task
        ArrayList<Integer> task = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        task.add(2, 7);
        Collections.reverse(task);
        task.remove(1);
        System.out.println(task);

        //HashSets
        HashSet<Member> memberSet = new HashSet<>();
        memberSet.add(new Member("Farah", "C", 2022, 1, 1));
        memberSet.add(new Member("Farah", "C", 2022, 1, 1));
        memberSet.add(new Member("Bobby", "D", 2023, 1, 1));
        for (Member m : memberSet) {
            System.out.println(m);
        } // only prints 2 not 3 as 1 is duplicate

        if (memberSet.contains((new Member("Farah", "C", 2022, 1,1)))){
            System.out.println("Farah is in the set");
        } else {
            System.out.println("Farah is not in the set");
        }

        System.out.println(makeFiveSet(42));

        System.out.println(longWordList("the hippopotamus is eating grass"));

        System.out.println(countDigitsInString("a1233bx"));

    }
}