package com.saca.exceptions;

public class LicorExistException extends RuntimeException{
    
    public LicorExistException(String nombre){
        super(nombre + " ya existe");
    }
}
