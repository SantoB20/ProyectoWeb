package com.example.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Licor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String nombre;
    @Basic
    private String pais;
    @Basic
    private String tipo;
    @Basic
    private int cantidad;
    @Basic
    private int grados;
    @Basic
    private int precio;
    //Default LAZY
    @ManyToMany(mappedBy = "productos", cascade = CascadeType.ALL)
    private List<Compra> compras = new ArrayList<>();

    public Licor(String nombre, String pais, String tipo, int cantidad, int grados, int precio){
        this.nombre = nombre;
        this.pais = pais;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.grados = grados;
        this.precio = precio;
    }

}
