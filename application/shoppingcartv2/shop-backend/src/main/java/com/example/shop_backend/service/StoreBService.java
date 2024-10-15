package com.example.shop_backend.service;

import java.util.List;

import com.example.shop_backend.model.storeB.StoreBStock;

// DataSourceFrom
// StoreB: https://fakestoreapi.com/products/
public interface StoreBService {
  
  List<StoreBStock> getStocks();
}
