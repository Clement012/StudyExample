package com.example.sb.connection.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentEntity {
  private int postId;
  private int id;
  private String name;
  private String email;
  private String body;
}
