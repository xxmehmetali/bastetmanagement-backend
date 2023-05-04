package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.baseresults.ErrorResult;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.SuccessResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.DataResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.ErrorDataResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.SuccessDataResult;

public class BaseController<T> {
    // START OF DATA RESULTS
    public SuccessDataResult<T> wrapSuccessDataResult(T data) {
        return new SuccessDataResult<>(data);
    }

    public SuccessDataResult<T> wrapSuccessDataResultWithMessage(T data, String message) {
        return new SuccessDataResult<>(data, message);
    }

    public SuccessDataResult<T> wrapSuccessDataResultWithOnlyMessage(String message) {
        return new SuccessDataResult<>(message);
    }

    public ErrorDataResult<T> wrapErrorDataResult(T data) {
        return new ErrorDataResult<>(data);
    }

    public ErrorDataResult<T> wrapErrorDataResultWithMessage(T data, String message) {
        return new ErrorDataResult<>(data, message);
    }

    public ErrorDataResult<T> wrapErrorDataResultWithOnlyMessage(String message) {
        return new ErrorDataResult<>(message);
    }

    public DataResult<T> wrapDataResult(T data, boolean success) {
        return new DataResult<>(data, success);
    }

    public DataResult<T> wrapDataResultWithMessage(T data, boolean success, String message) {
        return new DataResult<>(data, success, message);
    }
    // END OF DATA RESULTS

    // START OF RESULTS
    public Result wrapResult(boolean success) {
        return new Result(success);
    }

    public Result wrapResultWithMessage(boolean success, String message) {
        return new Result(success, message);
    }

    public SuccessResult wrapSuccessResult() {
        return new SuccessResult();
    }

    public SuccessResult wrapSuccessResultWithMessage(String message) {
        return new SuccessResult(message);
    }

    public ErrorResult wrapErrorResult() {
        return new ErrorResult();
    }

    public ErrorResult wrapErrorResultWithMessage(String message) {
        return new ErrorResult(message);
    }

    // END OF RESULTS

}
