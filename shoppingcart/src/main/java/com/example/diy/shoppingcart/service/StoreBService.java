package com.example.diy.shoppingcart.service;

import java.util.List;
import com.example.diy.shoppingcart.model.storeB.StoreBStock;

// DataSourceFrom
// StoreB: https://fakestoreapi.com/products/
public interface StoreBService {
  
  List<StoreBStock> getStocks();
}
