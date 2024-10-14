package com.example.oop_battle.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.oop_battle.controller.BattleController;

@Controller
public class ViewController {  

    @Autowired
    private BattleController battleController;

    @GetMapping("/battle")
    public String battlePage(Model model) {
        model.addAttribute("characters", battleController.getAllCharacters());
        return "battle";
    }
}




