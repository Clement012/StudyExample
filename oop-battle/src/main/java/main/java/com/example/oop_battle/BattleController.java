package main.java.com.example.oop_battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BattleController {

    @Autowired
    private BattleService battleService;

    @GetMapping("/battle")
    public String battlePage(Model model) {
        // Set the initial state for the page
        model.addAttribute("characteristics", Characteristic.values());
        return "battle";
    }

    @PostMapping("/battle")
    public String performBattle(
            @RequestParam int hp1,
            @RequestParam int attack1,
            @RequestParam Characteristic characteristic1,
            @RequestParam int hp2,
            @RequestParam int attack2,
            @RequestParam Characteristic characteristic2,
            Model model) {

        // Create two characters based on input
        Character character1 = new Character(hp1, attack1, characteristic1);
        Character character2 = new Character(hp2, attack2, characteristic2);

        // Perform battle (Character 1 attacks Character 2)
        battleService.battle(character1, character2);

        // Return updated state to the view
        model.addAttribute("hp1", character1.getHp());
        model.addAttribute("attack1", character1.getAttack());
        model.addAttribute("characteristic1", character1.getCharacteristic().getName());

        model.addAttribute("hp2", character2.getHp());
        model.addAttribute("attack2", character2.getAttack());
        model.addAttribute("characteristic2", character2.getCharacteristic().getName());

        model.addAttribute("characteristics", Characteristic.values());

        return "battle";
    }
  }
