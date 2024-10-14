package com.example.oop_battle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.oop_battle.model.classic.Character;
import com.example.oop_battle.service.BattleService;


@Controller
public class BattleController {

    @Autowired
    private BattleService battleService;

    @GetMapping("/")
    public List<Character> getAllCharacters(){
        return battleService.getAllCharacters();
    }

    // @GetMapping("/battle")
    // public String battlePage(Model model) {
    //     // Set the initial state for the page
    //     model.addAttribute("characteristics", Characteristic.values());
    //     return "battle";
    // }

    // @PostMapping("/battle")
    // public String performBattle(Model model) {

    //     // Create two characters based on input
    //     Character character1 = new Character(characteristic1);
    //     Character character2 = new Character(characteristic2);

    //     // Perform battle (Character 1 attacks Character 2)
    //     battleService.battle(character1, character2);
    //     // battleService.battle(character2, character1);

    //     // Return updated state to the view
    //     model.addAttribute("characteristic1", character1.getCharacteristic());
    //     model.addAttribute("hp1", character1.getHp());
    //     model.addAttribute("attack1", character1.getAttack());
        
    //     model.addAttribute("characteristic2", character2.getCharacteristic());
    //     model.addAttribute("hp2", character2.getHp());
    //     model.addAttribute("attack2", character2.getAttack());
        
    //     model.addAttribute("characteristics", Characteristic.values());

    //     return "battle";
    // }

    // public static void main(String[] args) {
    //     BattleController output = new BattleController();
    //     List<Character> characters = output.getAllCharacters();
    //     System.out.println(characters);
    // }
  }
