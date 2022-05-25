package com.saca.repositories;

import com.saca.entities.compraDetalle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface detalleCompraRepository extends JpaRepository<compraDetalle,Long>{
    
}
