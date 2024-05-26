package com.Learnwise.servises;

import java.util.List;

import com.Learnwise.entity.Comments;

public interface commentSreviec {
	
	List<Comments> commentList();
	
	String addComment(Comments comment);

}
