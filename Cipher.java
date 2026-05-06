package com.javarush.task.jdk13.task53.task5307;

import java.util.ArrayList;

public class Cipher {
    private final ArrayList<Character> abc = new ArrayList<>();

    public Cipher() {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя .,:-!?\"";

        for (char c : alphabet.toCharArray()) {
            abc.add(c);
        }
    }

    public ArrayList<Character> getAbc() {
        return abc;
    }

    public String encrypt(String input, int shift) {
        input = input.toLowerCase();
        char[] characters = input.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            int idx = abc.indexOf(characters[i]);

            if (idx == -1) {
                continue;
            }

            idx = (idx + shift) % abc.size();
            if (idx < 0) idx += abc.size();

            characters[i] = abc.get(idx);
        }

        return new String(characters);
    }

    public String decrypt(String input, int shift) {
        return this.encrypt(input, -shift);
    }
}
