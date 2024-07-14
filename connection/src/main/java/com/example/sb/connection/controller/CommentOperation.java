package com.example.sb.connection.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.sb.connection.model.Comment;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CommentOperation {
  
  @GetMapping(value = "/comments")
  List<Comment> getComments() throws JsonProcessingException;
}
