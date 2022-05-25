package com.saca.exceptions;

public class LicorModErrorException extends RuntimeException{
    
    public LicorModErrorException(){
        super("Error al modificar");
    }
}
