package com.example.diy.shoppingcart.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.diy.shoppingcart.controller.StoreAOperation;
import com.example.diy.shoppingcart.model.storeA.StoreAStock;
import com.example.diy.shoppingcart.model.storeA.StoreAType;
import com.example.diy.shoppingcart.service.StoreAService;

@RestController
public class StoreAController implements StoreAOperation{
  
  @Autowired
  private StoreAService storeAService;

  @Override
  public List<StoreAStock> getStocks(){
    return storeAService.getStocks();
  }

  @Override
  public List<StoreAType> getTypes(){
    return storeAService.getTypes();
  }
}
