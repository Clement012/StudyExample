package com.example.pokemon_backend.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.example.pokemon_backend.modelDTO.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PokemonService {

  @Autowired
  private ResourceLoader resourceLoader;

  @Autowired
  private ObjectMapper objectMapper;

    // public Resource getResource() { //default
    //   return resourceLoader.getResource("classpath:static/pokedex.json");
    // }

    public List<Pokemon> getPokemons() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/pokedex.json");
        InputStream inputStream = resource.getInputStream();
        String jsonContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        Pokemon[] pokemonArray = objectMapper.readValue(jsonContent, Pokemon[].class);
        return List.of(pokemonArray);
    }
}

