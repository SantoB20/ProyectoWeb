package com.example.repositories;

import com.example.entities.Licor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LicorRepository extends JpaRepository<Licor, Long> {

    Optional<Licor> findByNombre(String nombre);

    List<Licor> findByTipo(String tipo);

    List<Licor> findByPais(String pais);

    List<Licor> findByCantidad(int cantidad);

    List<Licor> findByCantidadGreaterThan(int cantidad);

    List<Licor> findByCantidadGreaterThanEqual(int cantidad);

    List<Licor> findByCantidadLessThan(int cantidad);

    List<Licor> findByCantidadLessThanEqual(int cantidad);

    List<Licor> findByGrados(int grados);

    List<Licor> findByGradosGreaterThan(int grados);

    List<Licor> findByGradosGreaterThanEqual(int grados);

    List<Licor> findByGradosLessThan(int grados);

    List<Licor> findByGradosLessThanEqual(int grados);

    List<Licor> findByPrecio(int precio);

    List<Licor> findByPrecioGreaterThan(int precio);

    List<Licor> findByPrecioGreaterThanEqual(int precio);

    List<Licor> findByPrecioLessThan(int precio);

    List<Licor> findByPrecioLessThanEqual(int precio);
}