package com.sparta.fc.controlflows;

public class Loops {

    public static void main(String[] args) {
        String[] names = new String[]{"Vineet", "Zainab", "Farah", "Haashim"};
        String vineet = names[0];
        System.out.println(vineet);

        int[] myArray = {1, 2, 3, 4, 5};

        double[] weights = new double[4]; // empty array, but with 4 elements
        weights[0] = 3.5;
        weights[1] = 4.2;
        weights[2] = 7.1;

        // for-each or enhanced for loop
        for (double x : weights) {
            System.out.println(x);
        }

        // same thing with a for loop
        for (int i = 0; i < weights.length; i++) {
            System.out.println(weights[i]);
        }

        System.out.println("While loop:");
        int i = 0;
        while (i < weights.length) {
            System.out.println(weights[i]);
            i++;
        }

        System.out.println("Do-while loop:");
        i = 0;
        do {
            System.out.println(weights[i]);
            i++;
        } while (i < weights.length);

        int[] nums = {10, 6, 22, -17, 3};
        System.out.println("Highest foreach loop: " + highestForEachLoop(nums));
        System.out.println("Highest for- loop: " + highestForLoop(nums));
        System.out.println("Highest while- loop: " + highestWhileLoop(nums));
        System.out.println("Highest do-while loop: " + highestDoWhileLoop(nums));
    }

    private static int highestForEachLoop(int[] nums) {
        int highest = Integer.MIN_VALUE; // sets highest to the lowest possible value that can be stored in an Integer
        for(int num : nums){
            if(num > highest){
                highest = num;
            }
        }
        return highest;
    }

    private static int highestForLoop(int[] nums) {
        int highest = Integer.MIN_VALUE;
        for (int i=0; i < nums.length; i++){
            if(nums[i] > highest){
                highest = nums[i];
            }
        }
        return highest;
    }

    private static int highestWhileLoop(int[] nums) {
        int highest = Integer.MIN_VALUE;
        int i = 0;
        while(i < nums.length){
            if (nums[i]> highest){
                highest = nums[i];
            }
            i++;
        }

        return highest;
    }

    private static int highestDoWhileLoop(int[] nums) {
        int highest = Integer.MIN_VALUE;
        int i = 0;
        do{
            if (nums[i]> highest){
                highest = nums[i];
            }
            i++;
        } while(i < nums.length);

        return highest;
    }
}
