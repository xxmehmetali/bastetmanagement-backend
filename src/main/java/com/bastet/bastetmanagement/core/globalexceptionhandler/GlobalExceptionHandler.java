package com.bastet.bastetmanagement.core.globalexceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // uygulamada herhangi bir yerde aritmetikexception alınırsa o exception burda yönetilir.
    // dışarıda aritmetichexception alınabilecek yerlere try catch yazmasakta olur. hata alınırsa buraya düşecek zaten
    @ExceptionHandler({ArithmeticException.class})
    public String arithmeticException() {
        return "aritmetik hata";
    }
}
