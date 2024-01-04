package com.institutohidrografico.shopping.exception;

public final class Validator {

    public static boolean isNull(Object value) {
        return value == null;
    }
    public static boolean hasDigit(String value) {
        return !isNull(value) && value.chars().anyMatch(Character::isDigit);
    }
    public static boolean hasLetter(String value) {
        return !isNull(value) && value.chars().anyMatch(Character::isLetter);
    }
    public static boolean hasLowerCase(String value) {
        return !isNull(value) && value.chars().anyMatch(Character::isLowerCase);
    }
    public static boolean hasUpperCase(String value) {
        return !isNull(value) && value.chars().anyMatch(Character::isUpperCase);
    }
    public static boolean hasLength(int length, String value) {
        return !isNull(value) && value.length() >= length;
    }
}