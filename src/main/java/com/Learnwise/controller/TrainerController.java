package com.Learnwise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Learnwise.entity.Course;
import com.Learnwise.entity.Lesson;
import com.Learnwise.servises.TrainerService;

@Controller
public class TrainerController {
	
	@Autowired
	TrainerService tService;
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam("courseId") int courseId,
			@RequestParam("courseName") String courseName,
			@RequestParam("coursePrice") int coursePrice ) {
		
		Course course=new Course();
		course.setCourseID(courseId);
		course.setCourseName(courseName);
		course.setCoursePrice(coursePrice);
		tService.AddCourse(course); 
		return "redirect:/addLesson";
	}

	@PostMapping("/lesson")
	public String lesson(@RequestParam("courseId") int courseId,
			@RequestParam("lessonId") int lessonId,
			@RequestParam("lessonName") String lessonName,
			@RequestParam("lessontopics") String lessontopics,
			@RequestParam("link") String link ) {
		
		Course course=tService.getCourse(courseId);
		Lesson lesson=new Lesson(lessonId,lessonName,lessontopics,link,course);
		tService.addLesson(lesson);
		
		course.getLessons().add(lesson);
		//System.out.println(courseId+lessonName+lessonId+lessontopics+link);
		return "redirect:/courses";
	}
	
	
	@GetMapping("/showCourses")
	public String showCourses(Model model) {
		List<Course> courseList=tService.courseList();
		
		model.addAttribute("courseList",courseList);
		
//		System.out.println(courseList);
		
		return"courses";
	}
	
	
	//newbymi
//	@GetMapping("/myPurchase")
//	public String myPurchaseList(Model model) {
//		List<Course> myPurchaseList=tService.courseList();
//		
//		model.addAttribute("courseList",myPurchaseList);
//		
//		
//		return"courses";
//	}
//	
	
	
}
 




