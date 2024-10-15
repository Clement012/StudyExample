package com.example.sb.connection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.example.sb.connection.infra.RedisHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Config {

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
   RedisHelper redisHelper(RedisConnectionFactory factory, ObjectMapper objectMapper){
    return new RedisHelper(factory , objectMapper);
   }
}
