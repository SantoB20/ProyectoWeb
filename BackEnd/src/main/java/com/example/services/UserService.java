package com.example.services;

import java.util.List;

import com.example.entities.User;
import com.example.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    
    @Autowired
    UserRepository repo;

    @Override
    public List<User> getUsers(){
        return repo.findAll();
    }

    @Override
    public User getUserById(Long id){
        return repo.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username){
        return repo.findByUsername(username).get();
    }
}
