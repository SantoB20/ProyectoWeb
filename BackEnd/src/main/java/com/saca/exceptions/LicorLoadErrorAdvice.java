package com.saca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LicorLoadErrorAdvice {

    @ResponseBody
    @ExceptionHandler(LicorLoadErrorException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String LicorLoadErrorhandler(LicorLoadErrorException ex){
        return ex.getMessage();
    }
    
}
