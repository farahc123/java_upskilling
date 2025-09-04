package com.sparta.fc.fileio;

import java.io.BufferedReader;
import java.io.IO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.awt.SystemColor.text;

public class App {
    public static void main(String[] args) {
        String myPathString = "src/main/resources/todo.txt";
        System.out.println("Read all lines using nio:");
        List<String> result = readNioAllLines(myPathString);
        for (String todo : result) {
            System.out.println(todo);
        }

        System.out.println("Write using nio (all text):");
        String myOutputPathString = "src/main/resources/output.txt";
        String whatToWrite = "testing testing";
        writeNio(myOutputPathString, whatToWrite);
        List<String> result2 = readNioAllLines(myOutputPathString);
        for (String output : result2) {
            System.out.println(output);
        }
    }

    // not meant for large files -- use streams for that
    private static List<String> readNioAllLines(String myPathString) {
        List<String> result = null;
        Path path = Paths.get(myPathString); // wraps variable as Path object -- required for .readAllLines method
        try {
            result = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static void readLineByLine(String myPathString) {
        String line;
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(myPathString));

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void readLineByLineWithResources(String myPathString) {
        // this method will close the resource automatically when leaving the try block
        String line;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(myPathString))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeNio(String myOutputPathString, String whatToWrite){
        Path thePath = Paths.get(myOutputPathString);
        try{
            Files.write(thePath, whatToWrite.getBytes());
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
}
