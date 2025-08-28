package com.sparta.fc.controlflows;

public class Selection {
    public static void main(String[] args) {
        String result = getGradeConditionalOperators(66);
        System.out.println(result);


    }

    public static String getGradeIfElse(int mark){
        if(mark >= 85){
            return "Distinction";
        }
        else if(mark >= 65){
            return "Pass";
        }
        else {
            return "Fail";
        }
    }

    public static String getGradeConditionalOperators(int mark){
        String grade = mark >= 65 ? (mark >= 85 ? "Distinction": "Pass") : "Fail";
        return grade;
    }

    public static String getPriority(int level){
        String priority = "Code ";
        switch(level){
            case 3:
                priority = priority + "Red";
                break;
            case 2:

            case 1:
                priority = priority + "Amber";
                break;
            case 0:
                priority = priority + "Green";
                break;
            default:
                priority = "error";
                break;
        }
        return priority;
    }

    // write tests for switch statement and conditional operator method
}
