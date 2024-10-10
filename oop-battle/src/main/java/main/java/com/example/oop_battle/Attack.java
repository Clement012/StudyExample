package main.java.com.example.oop_battle;

import lombok.Getter;

@Getter

public class Attack {
  
  private int damage;

  public int applyBonus(int attack, Characteristic characteristic) {  
    if (characteristic.getId() <= 4){
      return attack;
    } else if (characteristic.getId() == 5){
      return attack;
    } else if (characteristic.getId() <= 8){
      return attack;
    }
    return attack;
   }
}
