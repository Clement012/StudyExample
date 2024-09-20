package com.example.shop_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.shop_backend.model.storeB.StoreBStock;

public interface StoreBOperation {
  
  @GetMapping(value = "/storebstock")
  List<StoreBStock> getStocks();
}
