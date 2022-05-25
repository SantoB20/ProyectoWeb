package com.saca.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import com.saca.backEnd.isAdmin;
import com.saca.dtos.CompraDTO;
import com.saca.dtos.detalleDTO;
import com.saca.entities.Compra;
import com.saca.entities.compraDetalle;
import com.saca.services.ICompraService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("reporte")
public class reportesController {

    @Autowired
    private ICompraService repoCompra;
    @Autowired
    private UsersController userCon;

    /*
     * Métodos REST para la sección de reporte de ventas e historial de usuario.
     */
    @isAdmin
    @GetMapping("hist/listar/{page}/{size}")
    public List<CompraDTO> getCompras(@PathVariable("page") int pagina, @PathVariable("size") int size) {

        Page<Compra> compras = repoCompra.obtenerCompras(pagina,size);

        List<CompraDTO> result = convertCDTOs(compras);

        return result;
    }
    @RolesAllowed({"ROLE_ADMIN","ROLE_CCLIENT"})
    @GetMapping("hist/{username}/{page}/{size}")
    public List<CompraDTO> getComprasByUsername(@PathVariable("username") String username, @PathVariable("page") int pagina, @PathVariable("size") int size){
        
        List<Compra> compras = repoCompra.obtenerComprasPorUsername(userCon.getByUsername(username),pagina,size);

        return convertCDTOs(compras);
    }

    private List<CompraDTO> convertCDTOs(Page<Compra> compras) {
        List<CompraDTO> result = new ArrayList<>();
        
        for (Compra compra : compras) {
            CompraDTO aux = new CompraDTO();
            aux.setId(compra.getId());
            aux.setTotal(compra.getTotal());
            aux.setComprador(compra.getComprador().getUsername());
            aux.setProductos(convertDDTOs(compra.getProductos()));
            result.add(aux);
        }

        return result;
    }

    private List<CompraDTO> convertCDTOs(List<Compra> compras) {
        List<CompraDTO> result = new ArrayList<>();
        
        for (Compra compra : compras) {
            CompraDTO aux = new CompraDTO();
            aux.setId(compra.getId());
            aux.setTotal(compra.getTotal());
            aux.setComprador(compra.getComprador().getUsername());
            aux.setProductos(convertDDTOs(compra.getProductos()));
            result.add(aux);
        }

        return result;
    }

    private List<detalleDTO> convertDDTOs(List<compraDetalle> detalles){
        List<detalleDTO> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        for (compraDetalle detalle : detalles) {
            result.add(mapper.map(detalle, detalleDTO.class));
        }

        return result;
    }

}
