package com.example.core.utils;

public final class StringUtils {

    private StringUtils() {}

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static String capitalize(String s) {
        if (isNullOrEmpty(s)) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String truncate(String s, int maxLength) {
        if (isNullOrEmpty(s) || s.length() <= maxLength) return s;
        return s.substring(0, maxLength) + "…";
    }

    public static String initials(String fullName) {
        if (isNullOrEmpty(fullName)) return "?";
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length == 1) return String.valueOf(parts[0].charAt(0)).toUpperCase();
        return (String.valueOf(parts[0].charAt(0)) + String.valueOf(parts[parts.length - 1].charAt(0))).toUpperCase();
    }
}
