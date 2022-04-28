package com.example.services;

import com.example.entities.Licor;

import java.util.List;

public interface ILicorService {

    public Licor crearLicor(Licor licor);

    public Licor obtenerLicor(Long id);

    public List<Licor> obtenerLicores();

    public List<Licor> obtenerPorTipo(String tipo);

    List<Licor> obtenerPorPais(String pais);

    public Licor modificarLicor(Licor newLicor);

    public boolean eliminarLicor(long id);
}
