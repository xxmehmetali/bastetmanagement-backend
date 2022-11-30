package com.bastet.bastetmanagement.core.utilities.results.baseresults;



public class ErrorResult extends Result{
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false,message);
    }
}
