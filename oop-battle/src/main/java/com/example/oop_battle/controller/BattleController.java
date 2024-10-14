package com.example.oop_battle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oop_battle.model.classic.Character;
import com.example.oop_battle.service.BattleService;


@RestController
public class BattleController {

    @Autowired
    private BattleService battleService;

    @GetMapping("/")
    public List<Character> getAllCharacters(){
        return battleService.getAllCharacters();
    }
  }
