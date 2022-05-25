package com.saca.rest;

import java.util.ArrayList;
import java.util.List;

import com.saca.backEnd.isClient;
import com.saca.dtos.CompraDTO;
import com.saca.dtos.detalleDTO;
import com.saca.entities.Compra;
import com.saca.entities.compraDetalle;
import com.saca.services.ICompraService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@isClient
@RequestMapping("compras")
public class comprasController {

    @Autowired
    ICompraService comprasService;

    /*
     * id: Id del comprador que realizo la compra
     */
    @PostMapping("crear/{id}")
    public CompraDTO crearCompra(@RequestBody CompraDTO compraDTO, @PathVariable("id") Long id) {
        Compra result = comprasService.saveCompra(convertCDTO(compraDTO), id);

        return convertCDTO(result);
    }

    /* Convertir compraDTO a Compra */
    private Compra convertCDTO(CompraDTO compraDTO) {
        return new Compra(compraDTO.getTotal(), convertDDTO(compraDTO.getProductos()));
    }

    /* Convertir lista de detallesDTO a lista de compraDetalles */
    private List<compraDetalle> convertDDTO(List<detalleDTO> detalles) {
        List<compraDetalle> result = new ArrayList<>();
        for (detalleDTO detalle : detalles) {
            result.add(new compraDetalle(detalle.getNombre(),detalle.getCosto()));
        }
        return result;
    }

    /* Convertir Compra a CompraDTO */
    private CompraDTO convertCDTO(Compra compra) {
        CompraDTO result = new CompraDTO();
        result.setId(compra.getId());
        result.setComprador(compra.getComprador().getUsername());
        result.setTotal(compra.getTotal());
        result.setProductos(convertToDDTO(compra.getProductos()));

        return result;
    }

    /* Convertir lista de compraDetalles a detallesDTO */
    private List<detalleDTO> convertToDDTO(List<compraDetalle> detalles) {
        List<detalleDTO> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        for (compraDetalle detalle : detalles) {
            result.add(mapper.map(detalle, detalleDTO.class));
        }
        return result;
    }

}
