package com.example.pokemon_backend.modelDTO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
  private int id;
  private Name name;
  private List<String> type;
  private Base base;

  @Getter
  @Setter
  @AllArgsConstructor
  @Builder
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Name {
    private String english;
    private String japanese;
    private String chinese;
    private String french;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @Builder
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Base {
    @JsonProperty("HP") // Ensure this matches the JSON key exactly
    private int hp;
    @JsonProperty("Attack") // Ensure this matches the JSON key exactly
    private int attack;
    @JsonProperty("Defense") // Ensure this matches the JSON key exactly
    private int defense;
    @JsonProperty("Sp. Attack") // Ensure this matches the JSON key exactly
    private int spAttack;
    @JsonProperty("Sp. Defense") // Ensure this matches the JSON key exactly
    private int spDefense;
    @JsonProperty("Speed") // Ensure this matches the JSON key exactly
    private int speed;
  }
}




