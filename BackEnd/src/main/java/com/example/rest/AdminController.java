package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import com.example.DTOs.CompraDTO;
import com.example.DTOs.LicorDTO;
import com.example.entities.Compra;
import com.example.entities.Licor;
import com.example.services.ICompraService;
import com.example.services.ILicorService;
import com.example.services.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private ILicorService repoLicor;
    @Autowired
    private ICompraService repoCompra;
    @Autowired
    private IUserService repoUser;

    /*
     * Métodos REST para la sección CRUD, del administrador.
     */
    @GetMapping("crud/listar")
    public List<LicorDTO> getLicores() {
        List<Licor> licores = repoLicor.obtenerLicores();

        return convertLDTOs(licores);

    }

    @GetMapping("crud/info/{id}")
    public LicorDTO infoLicor(@PathVariable("id") Long id) {
        Licor licor = repoLicor.obtenerLicor(id);

        return convertDTO(licor);
    }

    @PostMapping("crud/crear")
    public LicorDTO crearLicor(@RequestBody LicorDTO licor) {
        Licor nuevo = repoLicor.crearLicor(convertEntity(licor));

        return convertDTO(nuevo);
    }

    @PutMapping("crud/modificar")
    public LicorDTO modificarLicor(@RequestBody LicorDTO licor) {
        Licor nuevo = repoLicor.modificarLicor(convertEntity(licor));
        return convertDTO(nuevo);
    }

    @DeleteMapping("crud/eliminar/{id}")
    public void eliminarLicor(@PathVariable("id") Long id) {
        repoLicor.eliminarLicor(id);    
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

    public Licor convertEntity(LicorDTO licor){

        ModelMapper mapper = new ModelMapper();

        Licor result = mapper.map(licor,Licor.class);

        return result;
    }

    /*
     * Métodos REST para la sección historial de ventas, del administrador.
     */
    @GetMapping("hist/listar")
    public List<CompraDTO> getCompras() {
        List<Compra> compras = repoCompra.obtenerCompras();

        return convertCDTOs(compras);
    }

    @GetMapping("hist/{username}")
    public List<CompraDTO> getComprasByUsername(@PathVariable("username") String username){
        
        List<Compra> compras = repoCompra.obtenerComprasPorUsername(repoUser.getUserByUsername(username));

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
