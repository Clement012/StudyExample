package com.example.diy.shoppingchart.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.diy.shoppingchart.model.storeB.StoreBStock;

public interface StoreBOperation {
  
  @GetMapping(value = "/storebstock")
  List<StoreBStock> getStocks();
}
