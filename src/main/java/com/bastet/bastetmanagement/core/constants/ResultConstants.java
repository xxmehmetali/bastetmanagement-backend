package com.bastet.bastetmanagement.core.constants;

public final class ResultConstants {
    private ResultConstants() {
    }

    public static final String FOUND_MESSAGE = "%s found.";
    public static final String NOT_FOUND_MESSAGE = "%s found.";
    public static final String ADDED_MESSAGE = "%s added.";
    public static final String LOGGED_IN = "You are Logged in.";
    public static final String NO_AVAILABLE_DATA = "No available data.";

    public static String loggedInMessage() {
        return LOGGED_IN;
    }

    public static String foundMessage(Class clazz) {
        return String.format(FOUND_MESSAGE, clazz.getSimpleName());
    }

    public static String notFoundMessage(Class clazz) {
        return String.format(NOT_FOUND_MESSAGE, clazz.getSimpleName());
    }

    public static String addedMessage(Class clazz) {
        return String.format(ADDED_MESSAGE, clazz.getSimpleName());
    }
}
