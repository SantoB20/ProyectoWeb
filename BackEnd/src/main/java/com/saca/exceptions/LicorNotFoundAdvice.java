package com.saca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LicorNotFoundAdvice {
    
    @ResponseBody
    @ExceptionHandler(LicorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String LicorNotFoundHandler(LicorNotFoundException ex){
        return ex.getMessage();
    }
}
