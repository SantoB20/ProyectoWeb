package com.saca.services;

import java.util.List;

import com.saca.dtos.UserDTO;
import com.saca.entities.Compra;

import org.springframework.data.domain.Page;

public interface ICompraService {
    
    public Page<Compra> obtenerCompras(int pagina, int size);
    
    public List<Compra> obtenerComprasPorUsername(UserDTO username,int pagina, int size);

    public Compra saveCompra(Compra nuevaCompra, Long id);
}
