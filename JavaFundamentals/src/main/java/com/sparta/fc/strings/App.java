package com.sparta.fc.strings;

public class App {
    public static void main(String[] args) {
        String name = "   Farah   ";
        char c = name.charAt(3);
        String lcName = name.toLowerCase();
        String ucName = name.toUpperCase();
        name = name.trim();
        c = name.charAt(3);
        System.out.println(stringExercise(" Java list fundamentals"));

        // example of splitting a String sentence
        String sentence = "My name is Farah";
        String[] words = sentence.split(" ");
        for(String word: words){
            System.out.println(word);
        }

        // example of splitting a CSV file
        String exampleCSV = "Farah,1993,Female";
        var values = exampleCSV.split(",");
        for(var value: values){
            System.out.println(value);
        }
    }

    public static String stringExercise(String myString){
        myString = myString.trim();
        myString = myString.toUpperCase();
        myString = myString.replace("L", "*");
        myString = myString.replace("T", "*");
        if (myString.contains("N")){
            int nIndex = myString.indexOf("N");
            myString = myString.substring(0, nIndex+1);
            return myString;
        }
        return myString;
    }

}
