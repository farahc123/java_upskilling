package com.sparta.fc.logging;

import java.io.IOException;
import java.util.logging.*;

public class App {

    public static final Logger LOGGER = Logger.getLogger(App.class.getName()); // only logs for this class and method

    public static void main() throws IOException {


        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE); // or another minimum level

        LOGGER.addHandler(consoleHandler); // puts the handler into action
        LOGGER.setUseParentHandlers(false); // tells java not to use the default handler, which means we won't get duplicate console messages

        try{
            FileHandler fileHandler = new FileHandler("src/main/resources/example.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } // true means the file won't be overwritten each time, just appended with new events
        catch(Exception e){
            e.printStackTrace();
        }

        LOGGER.setLevel(Level.ALL);
        LOGGER.log(Level.SEVERE, "SEVERE is a message level indicating a problem"); // highest
        LOGGER.log(Level.WARNING, "WARNING is a message level indicating a potential problem");
        LOGGER.log(Level.INFO, "INFO is a message level for informational messages");
        LOGGER.log(Level.CONFIG, "CONFIG is a message level for static configuration messages");
        LOGGER.log(Level.FINE, "FINE is a message level providing tracing information");
        LOGGER.log(Level.FINER, "FINER indicates a fairly detailed tracing message");
        LOGGER.log(Level.FINEST, "FINEST indicates a highly detailed tracing message");   // lowest
        // LOGGER.log(Level.OFF, "Logging is off");
    }
}
