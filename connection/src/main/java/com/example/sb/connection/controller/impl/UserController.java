package com.example.sb.connection.controller.impl;

import java.util.List;
import javax.naming.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.connection.controller.UserOperation;
import com.example.sb.connection.dto.UserDTO;
import com.example.sb.connection.entity.UserEntity;
import com.example.sb.connection.model.User;
import com.example.sb.connection.service.UserService;

@RestController
public class UserController implements UserOperation {
  
  @Autowired
  private UserService userService;

  @Override
  public List<User> getUsers(){
    return userService.getUsers();
  }

  @Override
  public List<UserEntity> getUserEntities(){
    return userService.getUserEntities();
  }

  @Override
  public List<UserEntity> getByName(String name) throws Exception{
    return userService.getByName(name);
  }
  
  @Override
  public UserEntity saveUser(UserEntity user){
    return userService.saveUser(user);
  }

  @Override
  public UserEntity deleteById(Long id) throws Exception{
    return userService.deleteById(id);
  }

  @Override
  public UserEntity updateEmail(Long id, UserDTO email) throws Exception{
    return userService.updateEmail(id,email);
  }

  @Override
  public UserEntity updateUser(Long id, UserEntity entity) throws Exception{
    return userService.updateUser(id,entity);
  }
}
