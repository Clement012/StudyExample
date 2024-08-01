package com.example.diy.shoppingcart.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.diy.shoppingcart.controller.StoreBOperation;
import com.example.diy.shoppingcart.model.storeB.StoreBStock;
import com.example.diy.shoppingcart.service.StoreBService;

@RestController
public class StoreBController implements StoreBOperation{
  
  @Autowired
  private StoreBService storeBService;

  @Override
  public List<StoreBStock> getStocks(){
    return storeBService.getStocks();
  }
}
