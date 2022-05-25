package com.saca.exceptions;

public class LicorLoadErrorException extends RuntimeException{
    
    public LicorLoadErrorException(){
        super("Error al cargar los licores");
    }
}
