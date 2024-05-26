package com.Learnwise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Learnwise.entity.Comments;
import com.Learnwise.entity.Users;
import com.Learnwise.servises.UserService;
import com.Learnwise.servises.commentSreviec;

@Controller
public class ServiceController {
	
	@Autowired
	UserService uService; 
	
	
	@PostMapping("/addUser")
	public String addUder(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("phone") long phone,
			@RequestParam("role") String role) {
		
		boolean emailExists=uService.checkEmail(email);
		
		if(emailExists==false) {
			Users user =new Users();
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setEmail(email);
			user.setPassword(password);
			user.setPhone(phone);
			user.setRole(role);
			// we can't use parameterized constructor because "id" we are not taking from users.
			// we are using setter to set INFO because "id" is automatically generated.
			
			
			//it will send the control to index page because("/login")
			uService.addUser(user);
			return "redirect:/login";
		}
		
	
		else {
			System.out.println("User already Exists");
			return "redirect:/register";
			
		}
	}
		
	
	//for login page (/register)
	
		@PostMapping("/validate")
		public String validate(@RequestParam("email") String email,
				@RequestParam("password") String password) {
			boolean val=uService.validate(email,password);
			//if user is valid
			if(val==true){
				
				//checking for role student/trainer
				if(uService.getUserRole(email).equals("trainer"))
				return "trainerHome";
				
				else {
					return "studentHome";
				}
			}
			else {
				System.out.println("Incorrect credentials");
				return "login"; 
			}
		}	
		
		
		@Autowired
		commentSreviec cService;
		
		@PostMapping("/addCommment")
		public String comments(@RequestParam("comment") String comment,
				Model model){
			
			Comments c=new Comments();
			c.setComment(comment);
			cService.addComment(c);
			
			List<Comments> cl=cService.commentList();
			model.addAttribute("comment",cl);
			
			return "redirect:/myCourses";
		}
		
		
		
}
