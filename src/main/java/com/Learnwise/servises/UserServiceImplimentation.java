package com.Learnwise.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Learnwise.entity.Users;
import com.Learnwise.repository.UserRepository;

@Service
public class UserServiceImplimentation implements UserService {

	@Autowired
	UserRepository repo;


	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "Student added sucessefully!";
	}


	//email already exists then return true else false;
	@Override
	public boolean checkEmail(String email) {
	return repo.existsByEmail(email);
	
	}


	//login credentials
	@Override
	public boolean validate(String email, String Password) {
		if( repo.existsByEmail(email)==true) {
			
			Users u=repo.getByEmail(email);
			String bdpass=u.getPassword();
			if(Password.equals(bdpass)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else{
			return false;	
		}
	}


	@Override
	public String getUserRole(String email) {
		Users u=repo.getByEmail(email);
		return u.getRole() ;
	}

}
