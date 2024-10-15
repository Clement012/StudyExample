package com.example.sb.connection.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.connection.controller.CommentOperation;
import com.example.sb.connection.model.Comment;
import com.example.sb.connection.service.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CommentController implements CommentOperation {
  
  @Autowired
  private CommentService commentService;

  @Override
  public List<Comment> getComments() throws JsonProcessingException{
    return commentService.getComments();
  }
}
