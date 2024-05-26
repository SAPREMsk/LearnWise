package com.Learnwise.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learnwise.entity.Lesson;
import com.Learnwise.repository.LessonRepository;


@Service
public class StudentServiceImplementation implements StudentServices {

	@Autowired
	LessonRepository lessonRepo;
	
	
	@Override
	public Lesson getlesson(int lessonId) {
		// TODO Auto-generated method stub
		return lessonRepo.findById(lessonId).get();
	}

}
