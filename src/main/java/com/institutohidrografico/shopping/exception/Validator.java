package com.institutohidrografico.shopping.exception;

public final class Validator {

    public static boolean isNull(Object value) {
        if(value == null) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean hasNumber(String value) {
        if (value == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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