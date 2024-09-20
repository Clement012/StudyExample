package com.example.shop_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.shop_backend.model.storeA.StoreAStock;
import com.example.shop_backend.model.storeA.StoreAType;

public interface StoreAOperation {
  
  @GetMapping(value ="/astock")
  List<StoreAStock> getStocks();

  @GetMapping(value ="/atype")
  List<StoreAType> getTypes();
}
