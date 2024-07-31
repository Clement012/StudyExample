package com.example.diy.shoppingchart.service;

import java.util.List;
import com.example.diy.shoppingchart.model.storeB.StoreBStock;

// DataSourceFrom
// StoreB: https://fakestoreapi.com/products/
public interface StoreBService {
  
  List<StoreBStock> getStocks();
}
