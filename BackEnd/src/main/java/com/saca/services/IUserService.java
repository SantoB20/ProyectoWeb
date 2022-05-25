package com.saca.services;

import com.saca.entities.User;

public interface IUserService {

    public User getUserById(Long id);

    public User getUserByUsername(String username);

    public User getByUserAndPassword(String username, String password);

    public User persistUser(User user);

    public boolean userExiste(String username);

    public void crearUser(User nuevo);
    
}
