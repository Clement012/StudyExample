package com.example.oop_battle.model.classic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Character {
    private final Characteristic characteristic;
    private int hp;
    private int attack;

    public Character(Characteristic characteristic){
        this.characteristic = characteristic;
        this.hp = characteristic.getHp();
        this.attack = characteristic.getAttack();
    }

    public void applyDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    public int getAttack(){
        return this.attack;
    }
}





