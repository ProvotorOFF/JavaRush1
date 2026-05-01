package com.javarush.task.jdk13.task53.task5307;

import java.util.Scanner;

public class MainApp {
    static FileManager fm;
    static Cipher cipher;
    static Validator validator;

    static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        System.out.println("Выбрите пункт меню:");
        printMenu();
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 ->
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
        System.out.println("Введите выходной файл");
        String out = sc.nextLine();
        if (!validator.isFileExists(in) || !validator.isFileExists(out)) {
            System.out.println("Входной или выходной файл отсутствует");
            return;
        }
        validator.isFileExists(in);
        validator.isFileExists(out);
    }
}
