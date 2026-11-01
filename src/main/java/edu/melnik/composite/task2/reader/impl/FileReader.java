package edu.melnik.composite.task2.reader.impl;

import edu.melnik.composite.task2.exception.UserExceptionComposite;
import edu.melnik.composite.task2.reader.DataReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader implements DataReader {

    private final String filePath;

    public FileReader(String filaPath) {
        this.filePath = filaPath;
    }

    @Override
    public String readFromFile() throws UserExceptionComposite {
        if (filePath == null) {
            throw new UserExceptionComposite("File name cannot be null");
        }
        try {
            Path path = Path.of(filePath);
           // List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            return Files.readString(path);
        } catch (IOException e) {
            throw new UserExceptionComposite("Failed to read file: " + filePath, e);
        }

    }
}
