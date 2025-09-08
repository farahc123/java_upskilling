package com.sparta.fc.streams;

import com.sparta.fc.hamcrest.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {

    @Test
    @DisplayName("when given an animal, getName returns the animal's name")
    void getNameReturnsName() {
        Animal dog = new Dog("Rover");
        Animal bird = new Bird("Zazu");

        assertThat(dog.getName(), is("Rover"));
        assertThat(bird.getName(), is("Zazu"));
    }

    @Test
    @DisplayName("when given a name, setName sets the animal's name")
    void setNameSetsName() {
        Animal dog = new Dog("Rover");
        Animal bird = new Bird("Zazu");

        dog.setName("Rex");
        bird.setName("Tweetie");

        assertThat(dog.getName(), is("Rex"));
        assertThat(bird.getName(), is("Tweetie"));
    }

    @Test
    @DisplayName("when given null for a name, setName throws exception")
    void setNullNameThrowsException() {
        Animal dog = new Dog("Rex");
        Animal bird = new Bird("Tweetie");

        Exception dogException = assertThrows(IllegalArgumentException.class, () -> dog.setName(null));
        Exception birdException = assertThrows(IllegalArgumentException.class, () -> bird.setName(null));
    }

    @Test
    @DisplayName("Constructor throws exception if name is null")
    void constructorThrowsForNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Dog(null));
        assertThrows(IllegalArgumentException.class, () -> new Bird(null));
    }


    @Test
    @DisplayName("when walk is called, animal walks")
    void animalWalks() {
        Dog dog = new Dog("Rover");
        Dog dog2 = new Dog("Rex");
        Bird bird = new Bird("Tweetie");
        Bird bird2 = new Bird("Zazu");

        String dogResult1 = dog.walk();
        String dogResult2 = dog2.walk();
        String birdResult1 = bird.walk();
        String birdResult2 = bird2.walk();

        assertThat(dogResult1, is("The dog Rover is walking"));
        assertThat(dogResult2, is("The dog Rex is walking"));
        assertThat(birdResult1, is("The bird Tweetie is walking"));
        assertThat(birdResult2, is("The bird Zazu is walking"));
    }

    @Test
    @DisplayName("when fly is called, animal flies")
    void animalFlies() {
        Bird bird = new Bird("Tweetie");

        String result = bird.fly();

        assertThat(result, is("The bird Tweetie is flying"));
    }

    @Test
    @DisplayName("equals and hashCode work as expected")
    void testEqualsAndHashCode() {
        Animal dog1 = new Dog("Rex");
        Animal dog2 = new Dog("Rex");
        Animal dog3 = new Dog("Buddy");
        Animal bird = new Bird("Rex");

        // duplicate objects are equal
        assertThat(dog1.equals(dog2), is(true));
        assertThat(dog2.equals(dog1), is(true));

        // hashcodes for duplicate objects are the same
        assertThat(dog1.hashCode(), is(dog2.hashCode()));

        // dogs with different names aren't equal
        assertThat(dog1.equals(dog3), is(false));

        // different animal subclasses with same name aren't equal
        assertThat(dog1.equals(bird), is(false));
    }


}
