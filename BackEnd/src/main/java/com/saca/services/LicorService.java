package com.saca.services;

import java.util.List;

import com.saca.entities.Licor;
import com.saca.exceptions.LicorModErrorException;
import com.saca.exceptions.LicorNotFoundException;
import com.saca.repositories.LicorRepository;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LicorService implements ILicorService {

    @Autowired
    private LicorRepository repo;

    @Override
    public Licor crearLicor(Licor licor) {
        return repo.save(licor);
    }

    @Override
    public Licor obtenerLicor(Long id) {
        return repo.findById(id).orElseThrow(() -> new LicorNotFoundException());
    }

    @Override
    public Page<Licor> obtenerLicores(int pagina, int size) {
        Page<Licor> licores = repo.findAll(PageRequest.of(pagina, size, Direction.ASC, "id"));
        return licores;
    }

    @Override
    public List<Licor> obtenerPorTipo(String tipo, int pagina, int size) {
        return repo.findByTipo(tipo, PageRequest.of(pagina, size, Direction.ASC, "id")).orElseThrow(() -> new LicorNotFoundException(tipo));
    }

    @Override
    public List<Licor> obtenerPorPais(String pais, int pagina, int size) {
        return repo.findByPais(pais, PageRequest.of(pagina, size, Direction.ASC, "id")).orElseThrow(() -> new LicorNotFoundException(pais));
    }

    @Override
    public List<Licor> obtenerPorCantidad(int cantidad, int pagina, int size) {
        return repo.findByCantidad(cantidad, PageRequest.of(pagina, size, Direction.ASC, "id"))
                .orElseThrow(() -> new LicorNotFoundException(cantidad));
    }

    @Override
    public List<Licor> obtenerPorGrados(int grados, int pagina, int size) {
        return repo.findByGrados(grados, PageRequest.of(pagina, size, Direction.ASC, "id"))
                .orElseThrow(() -> new LicorNotFoundException(grados));
    }

    @Override
    public List<Licor> obtenerPorPrecio(int precio, int pagina, int size) {
        return repo.findByPrecio(precio, PageRequest.of(pagina, size, Direction.ASC, "id"))
                .orElseThrow(() -> new LicorNotFoundException(precio));
    }

    @Override
    public Licor modificarLicor(Licor newLicor) {
        Licor licor = repo.findById(newLicor.getId()).map(provider -> {
            provider.setNombre(newLicor.getNombre());
            provider.setPais(newLicor.getPais());
            provider.setTipo(newLicor.getTipo());
            provider.setCantidad(newLicor.getCantidad());
            provider.setGrados(newLicor.getGrados());
            provider.setPrecio(newLicor.getPrecio());

            return repo.save(provider);
        }).orElseThrow(() -> new LicorModErrorException());
        return licor;
    }

    @Override
    public boolean eliminarLicor(Long id) {
        repo.deleteById(id);
        return repo.existsById(id);
    }

    @Override
    public boolean existeLicor(String nombre) {
        return repo.existsByNombre(nombre);
    }
}
