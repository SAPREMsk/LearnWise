package com.Learnwise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String lodin() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
	// not for performing any action, it has made to open particular web page
	// Not mandatory to give same to action in "createCourse action"
	@GetMapping("/createCourse")
	public String createCourse() {
		return "createCourse";
	}
	
	
	// not for performing any action
	// it has made to open particular web page
	@GetMapping("/addLesson")
	public String addLesson() {
		return "addLesson";
	}
	
	
	@GetMapping("/trainerHome")
	public String trainerHome() {
		return "trainerHome";
	}
	
	@GetMapping("/studentHome")
	public String studentHome() {
		return "studentHome";
	}
	
	@GetMapping("/courses")
	public String courses() {
		return "courses";
	}
	
	@GetMapping("/myCourses")
	public String myCourses() {
		return "myCourses";
	}
	
	@GetMapping("/purchase")
	public String purchase() {
		return "purchase";
	}
	
	@GetMapping("/demoLesson")
	public String demoLesson() {
		return "demoLesson";
	}
	
	
	
}
