package com.bastet.bastetmanagement.core.globalexceptionhandler;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.ErrorResult;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
