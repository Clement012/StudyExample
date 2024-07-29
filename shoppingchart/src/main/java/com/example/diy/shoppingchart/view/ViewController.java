package com.example.diy.shoppingchart.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.diy.shoppingchart.controller.StoreAOperation;
import com.example.diy.shoppingchart.model.storeA.StoreAStock;
import com.example.diy.shoppingchart.model.storeA.StoreAType;

@Controller
public class ViewController {

  @Autowired
  private StoreAOperation storeAOperation;
  
  @GetMapping(value ="/")
  public String frontpage(Model model){
    List<StoreAStock> stocks = storeAOperation.getStocks();
    model.addAttribute("stocks", stocks);
    return "frontpage";
  }

  @GetMapping(value ="/atype")
  public String atype(Model model){
    List<StoreAType> types = storeAOperation.getTypes();
    model.addAttribute("types", types);
    return "StoreAType";
  }
}
