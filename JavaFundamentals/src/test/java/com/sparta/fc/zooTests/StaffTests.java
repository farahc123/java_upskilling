package com.sparta.fc.zooTests;

import com.sparta.fc.zoo.Cleaner;
import com.sparta.fc.zoo.Staff;
import com.sparta.fc.zoo.Zookeeper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.time.LocalDate;

public class StaffTests {

    @Test
    @DisplayName("getFirstName returns zookeeper and cleaner's first names")
    public void getFirstNamesTest() {
        Staff zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");
        Staff cleaner1 = new Cleaner("John", "Roberts", 2020, 1, 1);

        Assertions.assertEquals("Sarah", zookeeper1.getFirstName());
        Assertions.assertEquals("John", cleaner1.getFirstName());
    }

    @Test
    @DisplayName("getLastName returns zookeeper and cleaner's last names")
    public void getLastNamesTest() {
        Staff zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");
        Staff cleaner1 = new Cleaner("John", "Roberts", 2020, 1, 1);

        Assertions.assertEquals("Smith", zookeeper1.getLastName());
        Assertions.assertEquals("Roberts", cleaner1.getLastName());
    }

    @Test
    @DisplayName("setLastName updates zookeeper and cleaner's last names")
    public void setLastNamesTest() {
        Staff zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");
        Staff cleaner1 = new Cleaner("John", "Roberts", 2020, 1, 1);

        zookeeper1.setLastName("Smithson");
        cleaner1.setLastName("Robertson");

        Assertions.assertEquals("Smithson", zookeeper1.getLastName());
        Assertions.assertEquals("Robertson", cleaner1.getLastName());
    }

    @Test
    @DisplayName("getJoinDate returns zookeeper and cleaner's join dates")
    public void getJoinDatesTest() {
        Staff zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");
        Staff cleaner1 = new Cleaner("John", "Roberts", 2020, 1, 1);

        Assertions.assertEquals(LocalDate.of(2024,1,1), zookeeper1.getJoinDate());
        Assertions.assertEquals(LocalDate.of(2020,1,1), cleaner1.getJoinDate());
    }

    @Test
    @DisplayName("serviceLength returns zookeeper and cleaner's service lengths")
    public void serviceLengthTest() {
        Staff zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");
        Staff cleaner1 = new Cleaner("John", "Roberts", 2020, 1, 1);

        Assertions.assertEquals("1 years, 7 months, 28 days", zookeeper1.serviceLength());
        Assertions.assertEquals("5 years, 7 months, 28 days", cleaner1.serviceLength());
    }

    // Zookeeper tests

    @Test
    @DisplayName("getAssignedEnclosure returns zookeeper's assigned enclosure")
    public void getAssignedEnclosureTest() {
        Zookeeper zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");

        Assertions.assertEquals("Gorilla", zookeeper1.getAssignedEnclosure());
    }

    @Test
    @DisplayName("setAssignedEnclosure updates zookeeper's assigned enclosure")
    public void setAssignedEnclosureTest() {
        Zookeeper zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");

        zookeeper1.setAssignedEnclosure("Lion");

        Assertions.assertEquals("Lion", zookeeper1.getAssignedEnclosure());
    }

    @Test
    @DisplayName("feedAnimals returns appropriate string")
    public void feedAnimalsTest() {
        Zookeeper zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");

        Assertions.assertEquals("Sarah Smith is feeding the Gorilla", zookeeper1.feedAnimals());
    }

    @Test
    @DisplayName("speak returns appropriate strings for zookeeper and cleaner")
    public void speakTest() {
        Zookeeper zookeeper1 = new Zookeeper("Sarah", "Smith", 2024, 1, 1, "Gorilla");
        Cleaner cleaner1 = new Cleaner("John", "Roberts", 2020, 1, 1);

        Assertions.assertEquals("Hello, I'm Sarah, your zookeeper!", zookeeper1.speak());
        Assertions.assertEquals("Hello, I'm John, your cleaner!", cleaner1.speak());
    }

}
