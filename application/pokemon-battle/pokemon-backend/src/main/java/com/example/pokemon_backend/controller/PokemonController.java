package com.example.pokemon_backend.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokemon_backend.mapper.PokemonMapper;
import com.example.pokemon_backend.modelDTO.PokemonDTO;
import com.example.pokemon_backend.service.PokemonService;


@RestController
public class PokemonController {
  
    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private PokemonMapper pokemonMapper;

    @GetMapping("/")
    public List<PokemonDTO> getPokemons() throws IOException {
        return pokemonService.getPokemons().stream()
               .map(e -> pokemonMapper.map(e))
               .collect(Collectors.toList());
    }

    // @GetMapping("/test")
    // public ResponseEntity<Resource> getJson() {
    //    Resource resource = pokemonService.getResource();
    //    return ResponseEntity.ok()
    //      .contentType(MediaType.APPLICATION_JSON)
    //      .body(resource);
    // }
}



