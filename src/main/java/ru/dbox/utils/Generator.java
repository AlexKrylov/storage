package ru.dbox.utils;

import java.util.Random;

public class Generator {
    public static String generateUnicUrlValue() {
        String pass  = "";
        Random random = new Random();
        int length = 50;
        for (int i = 0; i < length; ++i) {
            char next = 0;
            int range = 10;
            switch(random.nextInt(3)) {
                case 0: {next = '0'; range = 10;} break;
                case 1: {next = 'a'; range = 26;} break;
                case 2: {next = 'A'; range = 26;} break;
            }
            pass += (char)((random.nextInt(range)) + next);
        }
        return pass;
    }
}
