package com.example.pokemon_backend.mapper;

import org.springframework.stereotype.Component;

import com.example.pokemon_backend.modelDTO.Pokemon;
import com.example.pokemon_backend.modelDTO.PokemonDTO;

@Component
public class PokemonMapper {
    public PokemonDTO map(Pokemon pokemon) {
      return PokemonDTO.builder()
              .id(pokemon.getId())
              .name(PokemonDTO.Name.builder()
                      .english(pokemon.getName().getEnglish())
                      .japanese(pokemon.getName().getJapanese())
                      .chinese(pokemon.getName().getChinese())
                //       .french(pokemon.getName().getFrench())
                      .build())
              .type(pokemon.getType())
              .base(PokemonDTO.Base.builder()
                      .hp(pokemon.getBase().getHp())
                      .MP(pokemon.getBase().getHp() -20) 
                      .attack(pokemon.getBase().getAttack())
                      .defense(pokemon.getBase().getDefense())
                      .spAttack(pokemon.getBase().getSpAttack())
                      .spDefense(pokemon.getBase().getSpDefense())
                      .speed(pokemon.getBase().getSpeed())
                      .build())
              .image("/images/" + String.format("%03d.png", pokemon.getId())) 
              .icon("/icons/" + String.format("%03dMS.png", pokemon.getId()))
              .smallImage("/thumbnails/" + String.format("%03d.png", pokemon.getId())) 
              .build();
  }
}


