package com.sparta.fc.enums;

import com.sparta.fc.enums.Day;

public class App {

    public static void main(String[] args) {
        Day dayOfTheWeek = Day.SUNDAY;

        switch (dayOfTheWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:{
                System.out.println("Have a lovely day at work!");
                break;
            }
            case FRIDAY:
                System.out.println("Nearly the weekend!");
                break;

            case SATURDAY:
            case SUNDAY: {
                System.out.println("Relax and enjoy!");
                break;
            }
        }
    }
}