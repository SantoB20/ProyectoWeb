package com.saca.dtos;

import java.util.ArrayList;
import java.util.List;


public class CompraDTO {
    
    private Long id;
    private String comprador;
    private int total;
    private List<detalleDTO> productos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComprador(){
        return this.comprador;
    }

    public void setComprador(String comprador){
        this.comprador = comprador;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<detalleDTO> getProductos(){
        return productos;
    }

    public void setProductos(List<detalleDTO> productos){
        this.productos = productos;
    }
}
