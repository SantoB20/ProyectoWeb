package com.saca.exceptions;

public class ComprasErrorLoadException extends RuntimeException{
    
    public ComprasErrorLoadException(){
        super("Error al cargar las compras");
    }
}
