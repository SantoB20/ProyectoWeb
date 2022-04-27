package com.example.repositories;

import java.util.List;

import com.example.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByTotal(int total);

    List<Compra> findByComprador(String comprador);

    List<Compra> findByTotalGreaterThan(int total);

    List<Compra> findByTotalGreaterThanEqual(int total);

    List<Compra> findByTotalLessThan(int total);

    List<Compra> findByTotalLessThanEqual(int total);

}