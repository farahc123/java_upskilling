package com.sparta.fc.enums;

public class SeasonsApp {

    public static void main(String[] args) {
        SeasonsEnum seasonOfYear = SeasonsEnum.SPRING;

        if (seasonOfYear== SeasonsEnum.SPRING){
            System.out.println("The daffodils are out");
        }
        else if(seasonOfYear== SeasonsEnum.SUMMER){
            System.out.println("The sun is out");
        }
        else if(seasonOfYear== SeasonsEnum.AUTUMN){
            System.out.println("The leaves are falling");
        }
        else{
            System.out.println("It's cold");
        }

        System.out.println("--- Looping through the SeasonsEnum values:");
        for(SeasonsEnum season: SeasonsEnum.values()){
            System.out.println(season);
        }
    }
}
