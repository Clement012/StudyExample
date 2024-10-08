package com.example.diy.shoppingcart.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.diy.shoppingcart.controller.StoreAOperation;
import com.example.diy.shoppingcart.model.storeA.StoreAStock;

@Controller
public class StoreAView {

  @Autowired
  private StoreAOperation storeAOperation;
  
  @GetMapping(value ="/astocks")
  public String astocks(Model model){
    List<StoreAStock> stocks = storeAOperation.getStocks();
    model.addAttribute("astocks", stocks);
    return "StoreAStock";
  }
}
