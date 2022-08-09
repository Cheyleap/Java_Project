package com.javaproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaproject.entity.User;
import com.javaproject.repository.UserRepo;

@Service
public class UserServiceDetails implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user=repo.findByName(name);
		if(user==null) {
			throw new UsernameNotFoundException("User is not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
	}
}
