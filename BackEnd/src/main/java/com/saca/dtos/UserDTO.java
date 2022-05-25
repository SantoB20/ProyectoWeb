package com.saca.dtos;

import java.util.List;

public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String celular;
    private String password;
    private String rol;
    private List<CompraDTO> Compras;

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<CompraDTO> getCompras() {
        return Compras;
    }

    public void setCompras(List<CompraDTO> compras) {
        Compras = compras;
    }

}
