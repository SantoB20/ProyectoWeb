package com.saca.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class compraDetalle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String nombre;

    @Basic
    private int costo;
    
    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    public compraDetalle(String nombre, int costo, Compra comprador){
        this.nombre = nombre;
        this.costo = costo;
        this.compra = comprador;
    }

    public compraDetalle(String nombre, int costo){
        this.nombre = nombre;
        this.costo = costo;
    }

}
