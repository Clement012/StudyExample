package com.example.sb.connection.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.sb.connection.infra.RedisHelper;
import com.example.sb.connection.model.Comment;
import com.example.sb.connection.service.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CommentServiceImpl implements CommentService{
  
  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.comments}")
  private String commentPath;

  @Autowired
  private RedisHelper redisHelper;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List <Comment> getComments() throws JsonProcessingException{    
    Comment []comments = redisHelper.get("comments", Comment[].class);
    if (comments != null){
      return List.of(comments);
    }
    String url = UriComponentsBuilder.newInstance() 
        .scheme("https").host(this.domain)  
        .path(commentPath).toUriString(); 
    comments = restTemplate.getForObject(url, Comment[].class); 
    this.redisHelper.set("comments", comments, Duration.ofSeconds(1L)); //for example 1sec 
    return Arrays.asList(comments);
  }
}
