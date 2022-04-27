package com.example.services;

import java.util.List;

import com.example.entities.User;

public interface IUserService {
    
    public List<User> getUsers();

    public User getUserById(Long id);

    public User getUserByUsername(String username);
    
}
