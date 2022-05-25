package com.saca.services;

import com.saca.entities.User;
import com.saca.exceptions.UserNotFoundException;
import com.saca.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    
    @Autowired
    UserRepository repo;

    @Override
    public User getUserById(Long id){
        return repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User getUserByUsername(String username){
        return repo.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public User getByUserAndPassword(String username, String password){
        return repo.findByUsernameAndPassword(username, password).orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public User persistUser(User user){
        return repo.save(user);
    }

    @Override
    public boolean userExiste(String username){
        return repo.existsByUsername(username);
    }

    @Override
    public void crearUser(User nuevo){
        repo.save(nuevo);
    }
}
