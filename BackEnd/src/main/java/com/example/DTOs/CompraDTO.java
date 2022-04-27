package com.example.DTOs;

import java.util.ArrayList;
import java.util.List;


public class CompraDTO {
    
    private Long id;
    private String comprador;
    private int total;
    private List<LicorDTO> productos = new ArrayList<>();

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

    public List<LicorDTO> getLicor(){
        return productos; 
    }

    public void setLicor(List<LicorDTO> productos){
        this.productos = productos;
    }
}
