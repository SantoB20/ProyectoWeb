package com.saca.services;

import com.saca.entities.Licor;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ILicorService {

    public Licor crearLicor(Licor licor);

    public Licor obtenerLicor(Long id);

    public Page<Licor> obtenerLicores(int pagina, int size);

    public List<Licor> obtenerPorTipo(String tipo, int pagina, int size);

    public List<Licor> obtenerPorPais(String pais, int pagina, int size);

    public List<Licor> obtenerPorCantidad(int cantidad, int pagina, int size);

    public List<Licor> obtenerPorGrados(int grados, int pagina, int size);
    
    public List<Licor> obtenerPorPrecio(int precio, int pagina, int size);

    public Licor modificarLicor(Licor newLicor);

    public boolean eliminarLicor(Long id);

    public boolean existeLicor(String nombre);
}
