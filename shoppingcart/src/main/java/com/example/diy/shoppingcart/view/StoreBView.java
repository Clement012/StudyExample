package com.example.diy.shoppingcart.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.diy.shoppingcart.controller.StoreBOperation;
import com.example.diy.shoppingcart.model.storeB.StoreBStock;

@Controller
public class StoreBView {

  @Autowired
  private StoreBOperation storeBOperation;
  
  @GetMapping(value ="/bstocks")
  public String bstocks(Model model){
    List<StoreBStock> stocks = storeBOperation.getStocks();
    model.addAttribute("bstocks", stocks);
    return "StoreBStock";
  }
}
