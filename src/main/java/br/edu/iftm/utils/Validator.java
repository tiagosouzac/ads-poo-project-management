package br.edu.iftm.utils;

public class Validator {
    public static class string {
        public static boolean isEmpty(String value) {
            return value.trim().isEmpty();
        }

        public static boolean minLength(String value, int minLength) {
            return value.trim().length() >= minLength;
        }

        public static boolean maxLength(String value, int maxLength) {
            return value.trim().length() <= maxLength;
        }

        public static boolean isValid(String value, int minLength, int maxLength) {
            return !isEmpty(value) && minLength(value, minLength) && maxLength(value, maxLength);
        }
    }

    public static class project {
        public static boolean isValidName(String name) {
            return Validator.string.isValid(name, 1, 255);
        }

        public static boolean isValidDescription(String description) {
            return Validator.string.maxLength(description, 255);
        }
    }

    public static class team {
        public static boolean isValidName(String name) {
            return Validator.string.isValid(name, 1, 255);
        }
    }
}
