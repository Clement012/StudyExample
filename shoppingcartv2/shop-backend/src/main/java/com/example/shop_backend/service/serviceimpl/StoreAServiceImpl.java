package com.example.shop_backend.service.serviceimpl;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.shop_backend.model.storeA.StoreAStock;
import com.example.shop_backend.model.storeA.StoreAType;
import com.example.shop_backend.service.StoreAService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Service
public class StoreAServiceImpl implements StoreAService{
  
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<StoreAStock> getStocks() {
    String url = "https://api.escuelajs.co/api/v1/products";
    RestTemplate restTemplate = new RestTemplate();
    String jsonResponse = restTemplate.getForObject(url, String.class);
    
    Gson gson = new Gson();
    Type listType = new TypeToken<List<StoreAStock>>(){}.getType();
    List<StoreAStock> storeA = gson.fromJson(jsonResponse, listType);
    return storeA;
}

  @Override
  public List<StoreAType> getTypes(){
    String url = "https://api.escuelajs.co/api/v1/categories";
    StoreAType[] storeA = restTemplate.getForObject(url, StoreAType[].class);
    return Arrays.asList(storeA);
  }
}
