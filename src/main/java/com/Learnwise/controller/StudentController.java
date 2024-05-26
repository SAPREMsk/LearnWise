package com.Learnwise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Learnwise.entity.Lesson;
import com.Learnwise.servises.StudentServices;

@Controller
public class StudentController {

	@Autowired
	StudentServices service;

	@PostMapping("/goToLesson")
	public String myLesson(@RequestParam("lessonId") int lessonId,
			Model model) {
		Lesson lesson = service.getlesson(lessonId);
		model.addAttribute("lesson",lesson);
		System.out.println(lesson);
		return "myLesson";
	}
	
	
}
