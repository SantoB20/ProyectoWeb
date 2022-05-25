package com.saca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LicorModErrorAdvice {
    
    @ResponseBody
    @ExceptionHandler(LicorModErrorException.class)
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    String LicorModErrorHandler(LicorModErrorException ex){
        return ex.getMessage();
    }
    
}
