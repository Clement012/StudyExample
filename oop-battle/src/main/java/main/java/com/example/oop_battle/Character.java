package main.java.com.example.oop_battle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Character {
    private int hp;
    private int attack;
    private final Characteristic characteristic;

    public Character(int hp, int attack, Characteristic characteristic) {
        this.hp = hp;
        this.attack = attack;
        this.characteristic = characteristic;
    }

    public Character(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void applyDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }
}
