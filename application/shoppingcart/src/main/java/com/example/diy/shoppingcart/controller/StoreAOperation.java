package com.example.diy.shoppingcart.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.diy.shoppingcart.model.storeA.StoreAStock;
import com.example.diy.shoppingcart.model.storeA.StoreAType;

public interface StoreAOperation {
  
  @GetMapping(value ="/storeastock")
  List<StoreAStock> getStocks();

  @GetMapping(value ="/storeatype")
  List<StoreAType> getTypes();
}
