package com.sparta.tfd;

import org.w3c.dom.ranges.Range;

public class Methods {

    // implement this method so that it returns true if x is greater than or equal to y
    public static boolean greaterEqual(int x, int y) {
        if(x>=y){
            return true;
        }
        else{
            return false;
        }

        // can be written as return x>=y;
    }

    // implement this method so that it takes an int as an input,
    // squares it, adds 101, divides the result by 7, then subtracts 4.
    // return a double.
    public static double BODMAS(int inputNumber) {
        double result = ((((inputNumber*inputNumber)+101)/7.0)-4);
        return result;

        // can be written as ((((Math.pow(inputNumber, 2))+101)/7.0)-4);
    }

    // implement this method so that it returns true if input is "password"
    // regardless of case
    public static boolean checkInput(String input) {
        input = input.toLowerCase();
        if (input.equals("password")) {
            return true;
        } else {
            return false;
        }

        // can be written as return input.equalsIgnoreCase().equals("password");
    }

    // implement this method so that it returns the sum of all the numbers from start to end
    public static int sumNums(int start, int end) {
        int sum = 0;
        for (int x = start; x <= end; x++) {
            sum += x;
        }
        return sum;
    }

    // implement this method so that it returns the sum
    // of all the numbers in the array nums
    public static int sumArray(int[] nums) {
        int sum = 0;
        for (int num: nums){ // for-each loop
            sum+=num;
        }
        return sum;
    }
}
