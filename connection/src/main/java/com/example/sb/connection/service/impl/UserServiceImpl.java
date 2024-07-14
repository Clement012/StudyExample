package com.example.sb.connection.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.naming.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.sb.connection.dto.UserDTO;
import com.example.sb.connection.entity.UserEntity;
import com.example.sb.connection.mapper.UserEntityMapper;
import com.example.sb.connection.model.User;
import com.example.sb.connection.repository.UserRepository;
import com.example.sb.connection.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  
  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String usersPath;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository repository;

  @Autowired 
  private UserEntityMapper mapper;

  @Override  
  public List<User> getUsers(){
    String url = UriComponentsBuilder.newInstance()
         .scheme("https").host(this.domain)
         .path(usersPath).toUriString();
      User[] users = restTemplate.getForObject(url, User[].class);
      return Arrays.asList(users);
  }

  @Override
  public void save(){
      getUsers().stream()
      .map(u -> mapper.map(u))
      .forEach(u -> repository.save(u));
  }

  @Override
  public List<UserEntity> getUserEntities(){
    return repository.findAll();
  }

  @Override
  public List<UserEntity> getByName(String name) throws Exception{
    Optional<List<UserEntity>> users = repository.findByName(name);
    if (users.isPresent()){
      return users.get();
    }
    throw new Exception("name not found");
  }

  @Override
  public UserEntity saveUser(UserEntity user){
    return repository.save(user);
  }

  @Override
  public UserEntity deleteById(Long id) throws Exception{
    Optional<UserEntity> user = repository.findById(id);
    if (user.isPresent()){
      repository.deleteById(id);
      return user.get();
    }
    throw new Exception("id not found");
  }

  @Override
  public UserEntity updateEmail(Long id,UserDTO email) throws Exception{
    Optional<UserEntity> user = repository.findById(id);
    if (user.isPresent()){
      UserEntity userEntity = user.get();
      userEntity.setEmail(email.getEmail());
      repository.save(userEntity);
      return userEntity;
    }
    throw new Exception("Email update Failed");
  }

  @Override
  public UserEntity updateUser(Long id, UserEntity entity) throws Exception{
    Optional<UserEntity> user = repository.findById(id);
    if (user.isPresent()){
      UserEntity userEntity = user.get();
      repository.save(userEntity);
      return userEntity;
    }
    throw new Exception("Update Failed");
  }
  
}
