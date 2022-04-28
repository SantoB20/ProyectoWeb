package com.example.services;

import java.util.List;

import com.example.entities.Licor;
import com.example.repositories.LicorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicorService implements ILicorService{
    
    @Autowired
    private LicorRepository repo;

    @Override
    public Licor crearLicor(Licor licor){
        return repo.save(licor);
    }

    @Override 
    public Licor obtenerLicor(Long id){
        return repo.getById(id);
    }

    @Override
    public List<Licor> obtenerLicores(){      
        return repo.findAll();
    }

    @Override
    public List<Licor> obtenerPorTipo(String tipo){
        return repo.findByTipo(tipo);
    }

    @Override
    public List<Licor> obtenerPorPais(String pais){
        return repo.findByPais(pais);
    }

    @Override
    public Licor modificarLicor(Licor newLicor){
        return repo.findById(newLicor.getId()).map( provider -> {
            provider.setNombre(newLicor.getNombre());
            provider.setPais(newLicor.getPais());
            provider.setTipo(newLicor.getTipo());
            provider.setCantidad(newLicor.getCantidad());
            provider.setGrados(newLicor.getGrados());
            provider.setPrecio(newLicor.getPrecio());

            return repo.save(provider);
        }).orElse(null);
    }

    @Override
    public boolean eliminarLicor(long id){
        repo.deleteById(id);
        return repo.existsById(id);
    }
}
