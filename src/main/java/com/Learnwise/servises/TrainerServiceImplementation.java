package com.Learnwise.servises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learnwise.entity.Course;
import com.Learnwise.entity.Lesson;
import com.Learnwise.repository.CourseRepository;
import com.Learnwise.repository.LessonRepository;

@Service
public class TrainerServiceImplementation implements TrainerService{
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	LessonRepository lessonRepo;
	
	@Override
	public String AddCourse(Course course) {

		courseRepo.save(course);
		return "Course Addeded Successfully!";
	}

	@Override
	public String addLesson(Lesson lesson) {
		lessonRepo.save(lesson);
		return "Lesson Addeded succefully!";
	}

	@Override
	public Course getCourse(int courseId) {
		return courseRepo.findById(courseId).get();
	}

	@Override
	public List<Course> courseList() {
		return courseRepo.findAll();
	}
	



}
