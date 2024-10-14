package com.example.oop_battle.model.classic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public enum Characteristic {
  WATER(1, 80, 20), 
  EARTH(2, 200 ,8), 
  WOOD(3, 180, 9),
  METAL(4, 150 ,12),
  FIRE(5, 40 ,30), 
  
  LIGHT(8, 100, 15), 
  DARK(9, 60 ,20),
  ;

  private final int charCode;
  private final int hp;
  private final int attack;

  public int getAttack(){
    return this.attack;
  }

  public int getHp(){
    return this.hp;
  }
}

