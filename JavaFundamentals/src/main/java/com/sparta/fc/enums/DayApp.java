package com.sparta.fc.enums;

public class DayApp {

    public static void main(String[] args) {
        Day dayOfTheWeek = Day.TUESDAY;

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