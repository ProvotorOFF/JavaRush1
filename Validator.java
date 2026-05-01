package com.javarush.task.jdk13.task53.task5307;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    private final Cipher cipher;

    public Validator(Cipher cipher) {
        this.cipher = cipher;
    }

    public boolean isValidKey(int key) {
        return key < this.cipher.getAbc().size();
    }

    public boolean isFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}
