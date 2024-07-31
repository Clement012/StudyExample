package com.example.diy.shoppingchart.service;

import java.util.List;
import com.example.diy.shoppingchart.model.storeA.StoreAStock;
import com.example.diy.shoppingchart.model.storeA.StoreAType;

// DataSourceFrom
// StoreA: https://fakeapi.platzi.com/
public interface StoreAService {
  
  List<StoreAStock> getStocks();

  List<StoreAType> getTypes();

}
