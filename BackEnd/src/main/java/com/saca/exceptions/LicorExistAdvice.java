package com.saca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LicorExistAdvice {
    
    @ResponseBody
    @ExceptionHandler(LicorExistException.class)
    @ResponseStatus(HttpStatus.FOUND)
    String LicorExistHandler(LicorExistException ex){
        return ex.getMessage();
    }
}
