package com.example.sb.connection.infra;

import java.time.Duration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RedisHelper {

  private RedisTemplate<String,String> redisTemplate;
  private ObjectMapper objectMapper;

  public RedisHelper(RedisConnectionFactory factory,ObjectMapper objectMapper){
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  public <T> void set(String key, T object) throws JsonProcessingException{
    String json = this.objectMapper.writeValueAsString(object);
    this.redisTemplate.opsForValue().set(key, json);
  }

  public <T> void set(String key, T object,Duration duration) throws JsonProcessingException{
    String json = this.objectMapper.writeValueAsString(object);
    this.redisTemplate.opsForValue().set(key, json, duration);
  }


  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException{  
    String json = this.redisTemplate.opsForValue().get(key);
    return json == null ? null : this.objectMapper.readValue(key, clazz);
  }
  
}


