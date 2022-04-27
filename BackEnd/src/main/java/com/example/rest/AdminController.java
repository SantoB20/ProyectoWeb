package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import com.example.DTOs.CompraDTO;
import com.example.DTOs.LicorDTO;
import com.example.entities.Compra;
import com.example.entities.Licor;
import com.example.services.ICompraService;
import com.example.services.ILicorService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AdminController {

    @Autowired
    private ILicorService repoLicor;
    @Autowired
    private ICompraService repoCompra;

    /*
     * Métodos REST para la sección CRUD, del administrador.
     */
    @GetMapping("/admin/crud/listar")
    public List<LicorDTO> getLicores() {
        List<Licor> licores = repoLicor.obtenerLicores();

        return convertLDTOs(licores);

    }

    @GetMapping("/admin/crud/info/{id}")
    public LicorDTO infoLicor(@PathVariable("id") Long id) {
        Licor licor = repoLicor.obtenerLicor(id);

        return convertDTO(licor);
    }

    @PostMapping("/admin/crud/crear")
    public LicorDTO crearLicor(@RequestBody Licor licor) {
        Licor nuevo = repoLicor.crearLicor(licor);

        return convertDTO(nuevo);
    }

    @PutMapping("/admin/crud/modificar/{id}")
    public LicorDTO modificarLicor(@RequestBody Licor licor, @PathVariable("id") Long id) {
        Licor nuevo = repoLicor.modificarLicor(licor, id);
        return convertDTO(nuevo);
    }

    @GetMapping("/admin/crud/eliminar/{id}")
    public boolean eliminarLicor(@PathVariable("id") Long id) {
        return repoLicor.eliminarLicor(id);    
    }

    public LicorDTO convertDTO(Licor licor) {

        ModelMapper mapper = new ModelMapper();

        LicorDTO result = mapper.map(licor, LicorDTO.class);

        return result;
    }

    public List<LicorDTO> convertLDTOs(List<Licor> licores) {
        List<LicorDTO> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        for (Licor licor : licores) {
            result.add(mapper.map(licor, LicorDTO.class));
        }

        return result;
    }

    /*
     * Métodos REST para la sección historial de ventas, del administrador.
     */
    @GetMapping("/admin/hist/listar")
    public List<CompraDTO> getCompras() {
        List<Compra> compras = repoCompra.obtenerCompras();

        return convertCDTOs(compras);
    }

    public List<CompraDTO> convertCDTOs(List<Compra> compras) {
        List<CompraDTO> result = new ArrayList<>();
        
        for (Compra compra : compras) {
            CompraDTO aux = new CompraDTO();
            aux.setId(compra.getId());
            aux.setTotal(compra.getTotal());
            aux.setComprador(compra.getComprador().getUsername());
            aux.setLicor(convertLDTOs(compra.getProductos()));
            result.add(aux);
        }

        return result;
    }
}
