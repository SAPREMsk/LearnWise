package com.Learnwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Learnwise.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{

}
