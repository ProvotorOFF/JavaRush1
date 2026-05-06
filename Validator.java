package com.javarush.task.jdk13.task53.task5307;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    private final Cipher cipher;

    public Validator(Cipher cipher) {
        this.cipher = cipher;
    }

    public boolean isValidKey(int key) {
        return key >= 0 && key < cipher.getAbc().size();
    }

    public boolean isFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }

    public boolean isValidText(String text) {
        String lower = text.toLowerCase();

        String[] words = {" и ", " в ", " не ", " на ", " что ", " я "};

        int score = 0;

        for (String word : words) {
            if (lower.contains(word)) {
                score++;
            }
        }

        return score >= 2;
    }
}
