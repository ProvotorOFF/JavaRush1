package com.javarush.task.jdk13.task53.task5307;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            return null;
        }
    }

    public void writeFile(String content, String path) {
        try {
            Files.writeString(Path.of(path), content);
        } catch (IOException e) {
            return;
        }
    }
}
