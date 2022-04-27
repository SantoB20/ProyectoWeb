package com.example.repositories;

import java.util.List;

import com.example.entities.Compra;
import com.example.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByTotal(int total);

    List<Compra> findByComprador(User user);

    List<Compra> findByTotalGreaterThan(int total);

    List<Compra> findByTotalGreaterThanEqual(int total);

    List<Compra> findByTotalLessThan(int total);

    List<Compra> findByTotalLessThanEqual(int total);

}