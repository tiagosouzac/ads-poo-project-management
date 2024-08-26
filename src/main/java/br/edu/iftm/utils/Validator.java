package br.edu.iftm.utils;

import java.util.Date;

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

    public static class date {
        public static boolean isOnOrBefore(Date date, Date endDate) {
            return date.compareTo(endDate) <= 0;
        }

        public static boolean isOnOrAfter(Date date, Date startDate) {
            return date.compareTo(startDate) >= 0;
        }
    }

    public static class project {
        public static boolean isValidName(String name) {
            return Validator.string.isValid(name, 1, 255);
        }

        public static boolean isValidDescription(String description) {
            return Validator.string.maxLength(description, 255);
        }

        public static boolean isValidEndDate(Date endAt, Date startAt) {
            return endAt.after(startAt);
        }
    }

    public static class team {
        public static boolean isValidName(String name) {
            return Validator.string.isValid(name, 1, 255);
        }
    }

    public static class member {
        public static boolean isValidName(String name) {
            return Validator.string.isValid(name, 1, 255);
        }
    }

    public static class task {
        public static boolean isValidDescription(String name) {
            return Validator.string.isValid(name, 1, 255);
        }

        public static boolean isValidCompletionDate(Date completionDate, Date projectStartAt, Date projectEndAt) {
            return Validator.date.isOnOrAfter(completionDate, projectStartAt)
                    && Validator.date.isOnOrBefore(completionDate, projectEndAt);
        }
    }

    public static class comment {
        public static boolean isValidComment(String name) {
            return Validator.string.isValid(name, 1, 255);
        }
    }
}
