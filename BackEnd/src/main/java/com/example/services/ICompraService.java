package com.example.services;

import java.util.List;

import com.example.entities.Compra;

public interface ICompraService {
    
    public List<Compra> obtenerCompras();
    
    public List<Compra> obtenerComprasPorUsername(String username);
}
