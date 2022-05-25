package com.saca.rest;

import java.util.ArrayList;
import java.util.List;

import com.saca.backEnd.isAdmin;
import com.saca.dtos.LicorDTO;
import com.saca.entities.Licor;
import com.saca.exceptions.LicorExistException;
import com.saca.services.ILicorService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Métodos REST para la sección CRUD, del administrador.
 */
@RestController
@isAdmin
@RequestMapping("crud")
public class crudController {

    @Autowired
    private ILicorService repoLicor;

    @GetMapping("listar/{page}/{size}")
    public List<LicorDTO> getLicores(@PathVariable("page") int pagina, @PathVariable("size") int size) {

        Page<Licor> licores = repoLicor.obtenerLicores(pagina, size);

        List<LicorDTO> result = convertLDTOs(licores);

        return result;

    }

    @GetMapping("info/{id}")
    public LicorDTO infoLicor(@PathVariable("id") Long id) {
        Licor licor = repoLicor.obtenerLicor(id);
        return convertDTO(licor);
    }

    /*
     * param: campo del licor que se quiere filtrar
     * filtro: el valor que se quiere obtener del filtro
     */
    @GetMapping("filtrar/{param}/{filtro}/{page}/{size}")
    public List<LicorDTO> getLicores(@PathVariable("param") String param, @PathVariable("filtro") String filtro,
            @PathVariable("page") int pagina, @PathVariable("size") int size) {

        List<Licor> licores = new ArrayList<>();

        switch (param) {
            case "tipo":
                licores = repoLicor.obtenerPorTipo(filtro, pagina, size);
                break;
            case "pais":
                licores = repoLicor.obtenerPorPais(filtro, pagina, size);
                break;
            case "cantidad":
                licores = repoLicor.obtenerPorCantidad(Integer.valueOf(filtro), pagina, size);
                break;
            case "grados":
                licores = repoLicor.obtenerPorGrados(Integer.valueOf(filtro), pagina, size);
                break;
            case "precio":
                licores = repoLicor.obtenerPorPrecio(Integer.valueOf(filtro), pagina, size);
                break;
        }

        return convertLDTOs(licores);

    }

    @PostMapping("crear")
    public LicorDTO crearLicor(@RequestBody LicorDTO licor) {
        if (repoLicor.existeLicor(licor.getNombre())) {
            throw new LicorExistException(licor.getNombre());
        }
        Licor nuevo = repoLicor.crearLicor(convertEntity(licor));
        return convertDTO(nuevo);
    }

    @PutMapping("modificar")
    public LicorDTO modificarLicor(@RequestBody LicorDTO licor) {
        if (repoLicor.existeLicor(licor.getNombre())) {
            throw new LicorExistException(licor.getNombre());
        }
        Licor nuevo = repoLicor.modificarLicor(convertEntity(licor));
        return convertDTO(nuevo);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminarLicor(@PathVariable("id") Long id) {
        repoLicor.eliminarLicor(id);
    }

    private LicorDTO convertDTO(Licor licor) {

        ModelMapper mapper = new ModelMapper();

        LicorDTO result = mapper.map(licor, LicorDTO.class);

        return result;
    }

    private List<LicorDTO> convertLDTOs(Page<Licor> licores) {
        List<LicorDTO> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        for (Licor licor : licores) {
            result.add(mapper.map(licor, LicorDTO.class));
        }

        return result;
    }

    private List<LicorDTO> convertLDTOs(List<Licor> licores) {
        List<LicorDTO> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        for (Licor licor : licores) {
            result.add(mapper.map(licor, LicorDTO.class));
        }

        return result;
    }

    private Licor convertEntity(LicorDTO licor) {

        ModelMapper mapper = new ModelMapper();

        Licor result = mapper.map(licor, Licor.class);

        return result;
    }

}
