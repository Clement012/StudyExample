package com.example.pokemon_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Config {
  
  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
   }

  // @Bean
  // ResourceLoader resourceLoader(){
  //   return new ResourceLoader();
  // }
}

