package com.saca.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic
    private int total;

    //Default LAZY
    @OneToMany(mappedBy = "compra", fetch = FetchType.LAZY)
    private List<compraDetalle> productos = new ArrayList<>();

    //Default EAGER
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User comprador;

    public Compra(User comprador){
        this.comprador = comprador;
    }

    public Compra(User comprador, int total){
        this.comprador = comprador;
        this.total = total;
    }

    public Compra(User comprador, int total, List<compraDetalle> productos){
        this.comprador = comprador;
        this.total = total;
        this.productos = productos;
    }

    public void agregarLicor(compraDetalle licor){
        this.productos.add(licor);
    }

    public Compra(int total, List<compraDetalle> productos){
        this.total = total;
        this.productos = productos;
    }

    public void clearCompras(){
        this.productos.clear();
    }

}
