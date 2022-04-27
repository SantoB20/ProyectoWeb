package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String username;
    @Basic
    private String email;
    @Basic
    private String celular;
    @Basic
    private String password;
    //Default LAZY
    @OneToMany(mappedBy = "comprador", orphanRemoval = false)
    private List<Compra> compras = new ArrayList<>();

    public User(String username, String email, String celular, String password) {
        this.username = username;
        this.email = email;
        this.celular = celular;
        this.password = password;
    }

    public void agregarCompra(Compra compra){
        this.compras.add(compra);
    }

    public User(String username, String email, String celular, String password, ArrayList<Compra> compras) {
        this.username = username;
        this.email = email;
        this.celular = celular;
        this.password = password;
        this.compras = compras;
    }
}
