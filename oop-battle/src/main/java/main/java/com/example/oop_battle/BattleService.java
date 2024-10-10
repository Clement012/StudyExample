package main.java.com.example.oop_battle;

import org.springframework.stereotype.Service;

import main.java.com.example.oop_battle.Character;

@Service
public class BattleService {

    public void battle(Character attacker, Character defender) {

        int attack = attacker.getAttack();
        defender.applyDamage(attack);
        // int boostedAttack = attacker.getCharacteristic().applyBonus(attacker.getAttack());
        // defender.applyDamage(boostedAttack);
    }
}
