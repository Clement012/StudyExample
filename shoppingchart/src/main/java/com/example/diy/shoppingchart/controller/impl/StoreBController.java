package com.example.diy.shoppingchart.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.diy.shoppingchart.controller.StoreBOperation;
import com.example.diy.shoppingchart.model.storeB.StoreBStock;
import com.example.diy.shoppingchart.service.StoreBService;

@RestController
public class StoreBController implements StoreBOperation{
  
  @Autowired
  private StoreBService storeBService;

  @Override
  public List<StoreBStock> getStocks(){
    return storeBService.getStocks();
  }
}
