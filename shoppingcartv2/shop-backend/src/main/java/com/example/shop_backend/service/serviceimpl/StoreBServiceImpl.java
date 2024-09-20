package com.example.shop_backend.service.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.shop_backend.model.storeB.StoreBStock;
import com.example.shop_backend.service.StoreBService;

@Service
public class StoreBServiceImpl implements StoreBService {
  
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<StoreBStock> getStocks(){
    String url = "https://fakestoreapi.com/products";
    StoreBStock[] stocks = restTemplate.getForObject(url, StoreBStock[].class);
    return Arrays.asList(stocks);
   }
}
