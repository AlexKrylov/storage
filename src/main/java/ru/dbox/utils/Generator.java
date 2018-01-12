package ru.dbox.utils;

import java.util.UUID;

public class Generator {
    public static String generateUrl() {
        String uuid = UUID.randomUUID().toString();
        return "uuid = " + uuid;
    }
}
