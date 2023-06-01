package com.bastet.bastetmanagement.core.constants;

public final class ResultConstants {
    private ResultConstants() {
    }

    public static final String FOUND_MESSAGE = "%s found.";
    public static final String NOT_FOUND_MESSAGE = "%s not found.";
    public static final String ADDED_MESSAGE = "%s added.";
    public static final String DELETED_MESSAGE = "%s deleted.";
    public static final String UPDATED_MESSAGE = "%s updated.";
    public static final String LOGGED_IN = "You are Logged in.";
    public static final String NO_AVAILABLE_DATA = "No available data.";
    public static final String DATA_LISTED = "All Data Listed For %s";
    public static final String DATA_LISTED_FOR_SELECTION = "All Data Listed For %s 's Selection";

    // Authentication
    public static final String USERNAME_ALREADY_EXISTS = "Username already exists.";

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
    public static String deletedMessage(Class clazz) {
        return String.format(DELETED_MESSAGE, clazz.getSimpleName());
    }
    public static String updatedMessage(Class clazz) {
        return String.format(DELETED_MESSAGE, clazz.getSimpleName());
    }
    public static String dataListedMessage(Class clazz) {
        return String.format(DATA_LISTED, clazz.getSimpleName());
    }
    public static String dataListedMessageForSelection(Class clazz) {
        return String.format(DATA_LISTED_FOR_SELECTION, clazz.getSimpleName());
    }
}
