package com.saca.services;

import java.util.ArrayList;
import java.util.List;

import com.saca.entities.User;
import com.saca.exceptions.UserNotFoundException;
import com.saca.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repoUsers;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
		User user = repoUsers.findByUsername(username).get();
		if (user == null) {
			throw new UserNotFoundException(username);
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getRoles(user));
	}

	private List<SimpleGrantedAuthority> getRoles(User user){
		List<SimpleGrantedAuthority> roles  = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRol()));

		return roles;
	}
}
