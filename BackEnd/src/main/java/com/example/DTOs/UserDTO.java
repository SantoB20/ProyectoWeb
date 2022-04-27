package com.example.DTOs;

import com.example.entities.Compra;

import java.util.List;

public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String celular;
    private String password;
    private List<Compra> Compras;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Compra> getCompras() {
        return Compras;
    }

    public void setCompras(List<Compra> compras) {
        Compras = compras;
    }

}
