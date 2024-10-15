package com.example.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
  
  @GetMapping(value = "/")
  public String model(){
    return "demo";
  }

  @GetMapping(value = "/test")
    public String test(){
      return "test";
    }
  
  @GetMapping(value = "/js")
    public String js(){
      return "jsdemo";
    }
  
}
