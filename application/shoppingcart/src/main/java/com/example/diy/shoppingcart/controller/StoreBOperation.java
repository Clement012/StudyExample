package com.example.diy.shoppingcart.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.diy.shoppingcart.model.storeB.StoreBStock;

public interface StoreBOperation {
  
  @GetMapping(value = "/storebstock")
  List<StoreBStock> getStocks();
}
