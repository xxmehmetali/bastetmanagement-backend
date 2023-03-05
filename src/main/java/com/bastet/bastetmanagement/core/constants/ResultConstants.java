package com.bastet.bastetmanagement.core.constants;

public final class ResultConstants
{
    private ResultConstants() {}

    public static final String FOUND_MESSAGE = "%s found.";
    public static final String NOT_FOUND_MESSAGE = "%s found.";

    public static String foundMessage(Class clazz){
        return String.format(FOUND_MESSAGE, clazz.getSimpleName());
    }

    public static String notFoundMessage(Class clazz){
        return String.format(NOT_FOUND_MESSAGE, clazz.getSimpleName());
    }
}
