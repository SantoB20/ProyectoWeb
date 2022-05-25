package com.saca.exceptions;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(){
        super("Usuario o password incorrecto/s");
    }

    public UserNotFoundException(Long id){
        super("Usuario no encontrado con id " + id);
    }

    public UserNotFoundException(String nombre){
        super(nombre + " no encontrado");
    }
}
