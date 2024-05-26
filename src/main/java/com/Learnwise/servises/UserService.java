package com.Learnwise.servises;

import com.Learnwise.entity.Users;

public interface UserService {

	// adds new user to database
	String addUser(Users user);
	
	//checks email is already present in database or not
	boolean checkEmail(String email);
	
	//validate users credentials
	boolean validate(String email, String Password);
	
	//get users role by providing role or checks for role student/trainer
	String getUserRole(String email);
}

