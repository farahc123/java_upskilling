package com.sparta.fc.zoo;

public class Lion extends Animal{

        private String favouriteFood;

        public Lion(String name, int year, int month, int day, String favouriteFood) {
            super(name, year, month, day);
            this.favouriteFood = favouriteFood;
        }

    public String getFavouriteFood() {
            return favouriteFood;
        }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    @Override
        public String speak() {
            return "roar";
        }
    }