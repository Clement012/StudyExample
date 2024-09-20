package com.example.shop_backend.service;

import java.util.List;

import com.example.shop_backend.model.storeA.StoreAStock;
import com.example.shop_backend.model.storeA.StoreAType;

// DataSourceFrom
// StoreA: https://fakeapi.platzi.com/
public interface StoreAService {
  
  List<StoreAStock> getStocks();

  List<StoreAType> getTypes();

}
