package br.edu.iftm.utils;

public class Validator {
    public static class string {
        public static boolean isEmpty(String value) {
            System.out.println(value != null);
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
}
