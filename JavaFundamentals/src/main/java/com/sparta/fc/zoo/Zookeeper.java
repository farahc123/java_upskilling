package com.sparta.fc.zoo;

public class Zookeeper extends Staff implements Speakable{

    private String assignedEnclosure;

    public Zookeeper(String firstName, String lastName, int year, int month, int day, String assignedEnclosure) {
        super(firstName, lastName, year, month, day);
        this.assignedEnclosure = assignedEnclosure;
    }

    public String getAssignedEnclosure() {
        return assignedEnclosure;
    }

    public void setAssignedEnclosure(String assignedEnclosure) {
        this.assignedEnclosure = assignedEnclosure;
    }

    public String feedAnimals(){
        return this.getFirstName() + " " + this.getLastName() + " is feeding the " + this.assignedEnclosure;
    }

    @Override
    public String speak(){
        return "Hello, I'm " + this.getFirstName() + ", your zookeeper!";
    }

}
