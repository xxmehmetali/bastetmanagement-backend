package com.bastet.bastetmanagement.core.globalexceptionhandler;

import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.customexceptions.CustomBindingException;
import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.customexceptions.UnauthorizedAccessException;
import com.bastet.bastetmanagement.core.utilities.BindingUtil;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.ErrorResult;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.DataResult;
import com.bastet.bastetmanagement.validators.ValidationErrors;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    // uygulamada herhangi bir yerde aritmetikexception alınırsa o exception burda yönetilir.
    // dışarıda aritmetichexception alınabilecek yerlere try catch yazmasakta olur. hata alınırsa buraya düşecek zaten
    @ExceptionHandler({ArithmeticException.class})
    public String arithmeticException() {
        return "aritmetik hata";
    }

    @ExceptionHandler({ModelNotFoundException.class})
    public ResponseEntity<Result> modelNotFoundException(ModelNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResult("Model not found : " + e.getMessage() ));
    }

    @ExceptionHandler({BadCredentialsException.class})
    public DataResult badCredentialsException() {
        DataResult dataResult = new DataResult(ResultConstants.NO_AVAILABLE_DATA,false, "Bad Credentials!");
        return dataResult;
    }

    @ExceptionHandler({InternalAuthenticationServiceException.class})
    public DataResult internalAuthenticationServiceException() {
        DataResult dataResult = new DataResult(ResultConstants.NO_AVAILABLE_DATA,false, "Authentication problem! Your account does not have an assigned employee. Please contact your manager.");
        return dataResult;
    }

    @ExceptionHandler({CustomBindingException.class})
    public DataResult customBindingException(CustomBindingException e) {
        ValidationErrors validationErrors = new ValidationErrors();
        BindingResult bindingResult = e.getBindingResult();
        BindingUtil.extractErrors(bindingResult, validationErrors);
        DataResult dataResult = new DataResult(validationErrors,false, "Validation Error! Please correct the wront fields.");
        return dataResult;
    }

    @ExceptionHandler({UnauthorizedAccessException.class})
    public Result unauthorizedAccessException(UnauthorizedAccessException e) {
        return new ErrorResult( Objects.nonNull(e.getMessage()) ? e.getMessage() : "Unauthorized Access!" );
    }

}
