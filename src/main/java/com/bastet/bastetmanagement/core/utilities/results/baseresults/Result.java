package com.bastet.bastetmanagement.core.utilities.results.baseresults;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Result {
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean success;
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public Result(boolean success) {
        this.success = success;
    }
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
