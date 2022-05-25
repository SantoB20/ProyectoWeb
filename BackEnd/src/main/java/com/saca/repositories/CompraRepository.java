package com.saca.repositories;

import java.util.List;

import com.saca.entities.Compra;
import com.saca.entities.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByTotal(int total);

    List<Compra> findByComprador(User user, Pageable pageable);

    List<Compra> findByTotalGreaterThan(int total);

    List<Compra> findByTotalGreaterThanEqual(int total);

    List<Compra> findByTotalLessThan(int total);

    List<Compra> findByTotalLessThanEqual(int total);

}