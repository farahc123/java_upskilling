package com.sparta.fc.zoo;

public class Chimpanzee extends Animal{

        private String favouriteToy;

        public Chimpanzee(String name, int year, int month, int day, String favouriteToy) {
            super(name, year, month, day);
            this.favouriteToy = favouriteToy;
        }

    public String getFavouriteToy() {
            return favouriteToy;
        }

    public void setFavouriteToy(String favouriteToy) {
        this.favouriteToy = favouriteToy;
    }

    @Override
        public String speak() {
            return "ooh ooh ah ah";
        }
    }
