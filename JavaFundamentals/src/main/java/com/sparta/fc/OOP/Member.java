package com.sparta.fc.OOP;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Member {
    private final String firstName;
    private String lastName;
    private final LocalDate joinDate;

    public Member(String firstName, String lastName, int year, int month, int day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = LocalDate.of(year, month, day);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public long getMemberDays(){
        return joinDate.until(LocalDate.now(), ChronoUnit.DAYS);
    }

    public String toString(){
        return this.getFullName() + " has been a member for " + this.getMemberDays() + " days";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Member member))
            return false; // checking to see if obj is not an object of the Member class, but if it is, storing it in member variable
        else { // if it is a member
            return Objects.equals(this.firstName, member.firstName) && Objects.equals(this.lastName, member.lastName) && Objects.equals(this.joinDate, member.joinDate);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, joinDate);
    }
}

// create a few more member objects
// print out their names, using the getter methods
// prinout the days since they have joined
// create an array of member objects, loop through them, and get their full name