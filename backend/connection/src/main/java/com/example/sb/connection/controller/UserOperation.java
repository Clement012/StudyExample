package com.example.sb.connection.controller;

import java.util.List;
import javax.naming.NameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sb.connection.dto.UserDTO;
import com.example.sb.connection.entity.UserEntity;
import com.example.sb.connection.model.User;

public interface UserOperation {
  
  // return Json directly
  @GetMapping(value = "/u")  
  List<User> getUsers();  

  // below: Searching + Crud at/from database
  @GetMapping(value = "/users") //read
  List<UserEntity> getUserEntities();

  @GetMapping(value = "/users/{name}") //read by field
  List<UserEntity> getByName(@PathVariable String name) throws Exception;

  @PostMapping(value = "/user") //create
  UserEntity saveUser(@RequestBody UserEntity user);

  @DeleteMapping(value = "/user") //delete
  UserEntity deleteById(@RequestParam Long id)throws Exception;

  @PatchMapping(value = "/user/email") // update by field
  UserEntity updateEmail(@RequestParam Long id,@RequestBody UserDTO email) throws Exception;

  @PutMapping(value = "/user/all")
  UserEntity updateUser(@RequestParam Long id,@RequestBody UserEntity entity) throws Exception;
}

