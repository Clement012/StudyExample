package com.example.diy.shoppingcart.service;

import java.util.List;
import com.example.diy.shoppingcart.model.storeA.StoreAStock;
import com.example.diy.shoppingcart.model.storeA.StoreAType;

// DataSourceFrom
// StoreA: https://fakeapi.platzi.com/
public interface StoreAService {
  
  List<StoreAStock> getStocks();

  List<StoreAType> getTypes();

}
