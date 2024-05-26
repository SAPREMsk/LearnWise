package com.Learnwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Learnwise.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
