package com.saca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ComprasErrorLoadAdvice {
    
    @ResponseBody
    @ExceptionHandler(ComprasErrorLoadException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String ComprasErrorLoadHandler(ComprasErrorLoadException ex){
        return ex.getMessage();
    }
}
