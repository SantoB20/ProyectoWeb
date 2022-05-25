package com.saca.repositories;

import com.saca.entities.Licor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LicorRepository extends JpaRepository<Licor, Long> {

    Optional<Licor> findByNombre(String nombre);

    Optional<List<Licor>> findByTipo(String tipo, Pageable pageable);

    Optional<List<Licor>> findByPais(String pais, Pageable pageable);

    Optional<List<Licor>> findByCantidad(int cantidad, Pageable pageable);

    Optional<List<Licor>> findByGrados(int grados, Pageable pageable);

    Optional<List<Licor>> findByPrecio(int precio, Pageable pageable);

    boolean existsByNombre(String nombre);

}