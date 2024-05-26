package com.Learnwise.servises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learnwise.entity.Comments;
import com.Learnwise.repository.CommentRepository;

@Service
public class commentServiceImplementation implements commentSreviec{

	@Autowired
	CommentRepository commentRepo;
	
	@Override
	public List<Comments> commentList() {
		return commentRepo.findAll();
	}

	@Override
	public String addComment(Comments comment) {
		
		commentRepo.save(comment);
		return "comment added";
	}

	
}
