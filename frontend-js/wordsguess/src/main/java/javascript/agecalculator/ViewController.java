package javascript.agecalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
  
  @GetMapping(name = "/")
  public String test(Model model){
    return "words";
  }
}
