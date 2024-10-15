package com.example.sb.connection.mapper;

import org.springframework.stereotype.Component;
import com.example.sb.connection.entity.UserEntity;
import com.example.sb.connection.model.User;

@Component
public class UserEntityMapper {
  public UserEntity map(User user){ 

   UserEntity userEntity = new UserEntity();
   userEntity.setId(user.getId());
   userEntity.setName(user.getName());
   userEntity.setUsername(user.getUsername());
   userEntity.setEmail(user.getEmail());
   userEntity.setPhone(user.getPhone());
   userEntity.setWebsite(user.getWebsite());
   userEntity.setAddrStreet(user.getAddress().getStreet());
   userEntity.setAddrSuite(user.getAddress().getSuite());
   userEntity.setAddrCity(user.getAddress().getCity());
   userEntity.setAddrZipcode(user.getAddress().getZipcode());
   userEntity.setAddrLatitude(user.getAddress().getGeo().getLatitude());
   userEntity.setAddrLongtitude(user.getAddress().getGeo().getLongtitude());
   userEntity.setCompanyName(user.getCompany().getName());
   userEntity.setCompanyCatchPharse(user.getCompany().getCatchPhrase());
   userEntity.setCompanyBusiness(user.getCompany().getBusiness());
   return userEntity;
  }
}
