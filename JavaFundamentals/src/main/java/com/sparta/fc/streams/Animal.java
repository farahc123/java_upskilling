package com.sparta.fc.streams;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.*;

public abstract class Animal {

    private String name;
    private static FileHandler fileHandler;

    static {
        try {
            // file logger
            fileHandler = new FileHandler("src/main/resources/animalLogs.log", 10_000_000, 1, true);
            fileHandler.setLevel(Level.INFO); // accepts INFO-level and above logs
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setupLogger(Logger logger) {
            // console handler
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.WARNING); // the console handler will only handle warnings and above
            logger.addHandler(consoleHandler);

            // adds previously set-up file handler
            logger.addHandler(fileHandler);

            logger.setUseParentHandlers(false); // stops double logging
            logger.setLevel(Level.INFO); // logger will generate messages at INFO level and above; whether handlers handle these depends on them
        }

    public Animal(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Logger logger = Logger.getLogger(getClass().getName());

        // Setup logger once
        if (logger.getHandlers().length == 0) { // sets up the logger once
            setupLogger(logger);
        }

        if (name == null) {
            logger.warning("Attempted to set name to null. Name not changed.");
            throw new IllegalArgumentException("Name must not be null");
        }

        this.name = name;
        logger.info("Name set to: " + name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
