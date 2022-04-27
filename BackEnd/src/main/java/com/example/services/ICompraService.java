package com.example.services;

import java.util.List;

import com.example.entities.Compra;
import com.example.entities.User;

public interface ICompraService {
    
    public List<Compra> obtenerCompras();
    
    public List<Compra> obtenerComprasPorUsername(User username);
}
