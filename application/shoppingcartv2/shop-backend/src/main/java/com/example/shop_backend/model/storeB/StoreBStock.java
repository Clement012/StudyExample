package com.example.shop_backend.model.storeB;

import lombok.Getter;

@Getter
public class StoreBStock {
  private int id;
  private String title;
  private double price;
  private String description;
  private String category;
  private String image;
  private Rating rating;

  @Getter
  public static class Rating{
    private double rate;
    private int count;
  }
}
