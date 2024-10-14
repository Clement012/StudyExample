package com.example.oop_battle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.oop_battle.model.classic.Character;
import com.example.oop_battle.model.classic.Characteristic;

@Service
public class BattleService {

    // public void battle(Character attacker, Character defender) {
    //     int attack = attacker.getAttack();
    //     defender.applyDamage(attack);
    //     // int boostedAttack = attacker.getCharacteristic().applyBonus(attacker.getAttack());
    //     // defender.applyDamage(boostedAttack);
    // }

    public List<Character> getAllCharacters(){
        List<Character> characters = new ArrayList<>();
        for (Characteristic characteristic : Characteristic.values()) {
            Character character = new Character(characteristic);
            characters.add(character);
        }
        return characters;
    }

    public static void main(String[] args) {
        BattleService output = new BattleService();
        List<Character> characters = output.getAllCharacters();
        System.out.println(characters);
    }
}
