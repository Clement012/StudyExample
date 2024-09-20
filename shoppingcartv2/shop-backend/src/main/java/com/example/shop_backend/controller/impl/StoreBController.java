package com.example.shop_backend.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop_backend.controller.StoreBOperation;
import com.example.shop_backend.model.storeB.StoreBStock;
import com.example.shop_backend.service.StoreBService;

@RestController
public class StoreBController implements StoreBOperation{
  
  @Autowired
  private StoreBService storeBService;

  @Override
  public List<StoreBStock> getStocks(){
    return storeBService.getStocks();
  }
}
