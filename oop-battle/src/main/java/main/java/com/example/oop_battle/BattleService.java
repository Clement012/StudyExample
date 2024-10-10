package main.java.com.example.oop_battle;

import org.springframework.stereotype.Service;

@Service
public class BattleService {

    public void battle(Character attacker, Character defender) {

        int boostedAttack = attacker.getCharacteristic().applyBonus(attacker.getAttack());
        
        defender.applyDamage(boostedAttack);
    }
}
