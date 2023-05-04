package com.bastet.bastetmanagement.core.utilities.results.dataresults;

import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResult<T> extends Result {
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }
}
