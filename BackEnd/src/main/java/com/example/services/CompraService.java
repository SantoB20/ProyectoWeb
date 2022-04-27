package com.example.services;

import java.util.List;

import com.example.entities.Compra;
import com.example.repositories.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService implements ICompraService{
    
    @Autowired
    private CompraRepository repo;

    @Override
    public List<Compra> obtenerCompras(){
        return repo.findAll();
    }

    @Override
    public List<Compra> obtenerComprasPorUsername(String username){
        return repo.findByComprador(username);
    }
}
