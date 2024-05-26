package com.Learnwise.servises;

import java.util.List;

import com.Learnwise.entity.Course;
import com.Learnwise.entity.Lesson;

public interface TrainerService {

	public String AddCourse(Course course);
	
	public String addLesson(Lesson lesson);
	
	public Course getCourse(int courseId);
	
	public List<Course> courseList();
}
