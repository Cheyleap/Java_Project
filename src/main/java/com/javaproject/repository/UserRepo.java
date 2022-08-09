package com.javaproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaproject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.name = ?1")
	User findByName(String name);
	
	@Query("SELECT u FROM User u WHERE u.password = ?1")
	User findByPassword(String password);
}
