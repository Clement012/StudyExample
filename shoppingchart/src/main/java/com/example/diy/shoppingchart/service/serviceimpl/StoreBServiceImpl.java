package com.example.diy.shoppingchart.service.serviceimpl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.diy.shoppingchart.model.storeB.StoreBStock;
import com.example.diy.shoppingchart.service.StoreBService;

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
