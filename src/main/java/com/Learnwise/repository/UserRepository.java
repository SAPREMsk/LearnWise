package com.Learnwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Learnwise.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
 
	boolean existsByEmail(String email);
	
	//object will send
	Users getByEmail(String email);
	
	
}
