package com.example.sb.connection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.sb.connection.repository.UserRepository;
import com.example.sb.connection.service.UserService;

@Component
public class Runner implements CommandLineRunner {
  
  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args){
    if (userRepository == null){
      userService.save(); 
    }
  }
}
