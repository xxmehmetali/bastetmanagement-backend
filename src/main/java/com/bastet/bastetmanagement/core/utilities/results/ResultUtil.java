package com.bastet.bastetmanagement.core.utilities.results;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

public class ResultUtil {
    public static boolean extractSuccess(Object object){
        return ! Objects.isNull(object);
    }
}
