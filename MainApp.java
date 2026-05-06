package com.javarush.task.jdk13.task53.task5307;

import java.util.Scanner;

public class MainApp {
    static FileManager fm;
    static Cipher cipher;
    static Validator validator;

    static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите пункт меню:");
        printMenu();
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> encrypt();
                case 2 -> decrypt();
                case 3 -> bruteForce();
                case 4 -> printMenu();
                case 5 -> System.exit(0);
            }
        }
    }

    static void init() {
        cipher = new Cipher();
        fm = new FileManager();
        validator = new Validator(cipher);
    }

    static void printMenu() {
        System.out.println("1. Зашифровать файл");
        System.out.println("2. Расшифровать файл");
        System.out.println("3. Брут-форс");
        System.out.println("4. Повтор меню");
        System.out.println("5. Выход");
    }

    static void encrypt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите входной файл:");
        String in = sc.nextLine();

        if (!validator.isFileExists(in)) {
            System.out.println("Входной  файл отсутствует");
            return;
        }

        System.out.println("Введите выходной файл");
        String out = sc.nextLine();

        System.out.println("Введите сдвиг");
        int shift = sc.nextInt();

        if (!validator.isValidKey(shift)) {
            System.out.println("Некорректный шифт");
            return;
        }

        fm.writeFile(cipher.encrypt(fm.readFile(in), shift), out);
    }

    static void decrypt() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите входной файл:");
        String in = sc.nextLine();

        if (!validator.isFileExists(in)) {
            System.out.println("Файл отсутствует");
            return;
        }

        System.out.println("Введите выходной файл:");
        String out = sc.nextLine();

        System.out.println("Введите сдвиг:");
        int shift = sc.nextInt();

        if (!validator.isValidKey(shift)) {
            System.out.println("Некорректный шифт");
            return;
        }

        fm.writeFile(cipher.decrypt(fm.readFile(in), shift), out);
    }

    static void bruteForce() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите зашифрованный файл:");
        String in = sc.nextLine();

        if (!validator.isFileExists(in)) {
            System.out.println("Файл отсутствует");
            return;
        }

        String text = fm.readFile(in);

        for (int key = 0; key < cipher.getAbc().size(); key++) {
            String decrypted = cipher.decrypt(text, key);

            if (validator.isValidText(decrypted)) {
                System.out.println("Найден ключ: " + key);

                System.out.println("Сохраняем результат...");
                fm.writeFile(decrypted, "bruteforce_result.txt");
                return;
            }
        }

        System.out.println("Ключ не найден. Либо текст как из зоны после проверки — мусор.");
    }
}
