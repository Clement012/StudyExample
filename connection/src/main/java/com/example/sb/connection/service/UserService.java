package com.example.sb.connection.service;

import java.util.List;
import javax.naming.NameNotFoundException;
import com.example.sb.connection.dto.UserDTO;
import com.example.sb.connection.entity.UserEntity;
import com.example.sb.connection.model.User;

//postgreSql
public interface UserService {
  
  List<User> getUsers();

  void save();

  List<UserEntity> getUserEntities();

  List<UserEntity> getByName(String name)throws Exception;

  UserEntity saveUser(UserEntity user);

  UserEntity deleteById(Long id)throws Exception;

  UserEntity updateEmail(Long id,UserDTO email) throws Exception;

  UserEntity updateUser(Long id, UserEntity entity) throws Exception;

}
