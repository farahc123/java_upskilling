package com.sparta.fc.OOP;

public class BaseballApp {

    public static void main(String[] args) {

        BaseballMember zainab = new BaseballMember("Zainab", "Farooq", 2022,12,6, "Fielder");
        System.out.println(zainab.getFullName());
        System.out.println(zainab.getMemberDays());
        System.out.println(zainab.getPosition());
        zainab.setPosition("Pitcher");
        System.out.println(zainab.getPosition());
        System.out.println(zainab.toString());
    }
}
