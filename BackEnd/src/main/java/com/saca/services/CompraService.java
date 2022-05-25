package com.saca.services;

import java.util.ArrayList;
import java.util.List;

import com.saca.dtos.UserDTO;
import com.saca.entities.Compra;
import com.saca.entities.User;
import com.saca.entities.compraDetalle;
import com.saca.exceptions.ComprasErrorLoadException;
import com.saca.repositories.CompraRepository;
import com.saca.repositories.detalleCompraRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CompraService implements ICompraService{
    
    @Autowired
    private CompraRepository repo;
    @Autowired
    private IUserService UsersService;
    @Autowired
    private detalleCompraRepository repoDetalles;

    @Override
    public Page<Compra> obtenerCompras(int pagina, int size){
        Page<Compra> compras = repo.findAll(PageRequest.of(pagina, size, Direction.ASC, "id"));
        if(compras == null){
            throw new ComprasErrorLoadException();
        }
        return compras;
    }

    @Override
    public List<Compra> obtenerComprasPorUsername(UserDTO username, int pagina, int size){
        ModelMapper mapper = new ModelMapper();
        List<Compra> compras = repo.findByComprador(mapper.map(username, User.class), PageRequest.of(pagina, size, Direction.ASC, "id"));
        if(compras == null){
            throw new ComprasErrorLoadException();
        }
        return compras;
    }

    @Override
    public Compra saveCompra(Compra nuevaCompra, Long id){
        User comprador = UsersService.getUserById(id);
        nuevaCompra.setComprador(comprador);
        List<compraDetalle> aux = new ArrayList<>(nuevaCompra.getProductos());
        nuevaCompra.clearCompras();
        repo.save(nuevaCompra);
        for(compraDetalle detalle : aux){
            nuevaCompra.agregarLicor(repoDetalles.save(new compraDetalle(detalle.getNombre(),detalle.getCosto(),nuevaCompra)));
        }
        repo.save(nuevaCompra);
        comprador.agregarCompra(nuevaCompra);
        UsersService.persistUser(comprador);
        return nuevaCompra;
    }
}
