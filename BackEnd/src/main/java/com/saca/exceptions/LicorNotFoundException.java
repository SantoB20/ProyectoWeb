package com.saca.exceptions;

public class LicorNotFoundException extends RuntimeException{
    
    public LicorNotFoundException(){
        super("Licor no encontrado");
    }

    public LicorNotFoundException(String requested){
        super("Licores con " + requested + "no encontrados");
    }

    public LicorNotFoundException(int num){
        super("Licores con " + num + "no encontrados");
    }
}
