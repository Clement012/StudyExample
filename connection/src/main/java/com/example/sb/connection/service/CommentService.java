package com.example.sb.connection.service;

import java.util.List;
import com.example.sb.connection.model.Comment;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CommentService {
  
  List<Comment> getComments() throws JsonProcessingException;
}
