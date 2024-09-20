package com.example.shop_backend.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop_backend.controller.StoreAOperation;
import com.example.shop_backend.model.storeA.StoreAStock;
import com.example.shop_backend.model.storeA.StoreAType;
import com.example.shop_backend.service.StoreAService;

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
