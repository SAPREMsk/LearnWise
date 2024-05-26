package com.Learnwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Learnwise.entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
