package com.example.shop_backend.model.storeA;

import java.util.List;

import lombok.Getter;

@Getter
public class StoreAStock {
  private int id;
  private String title;
  private double price;
  private String description;
  private List<String> images;
  private String creationAt;
  private String updateAt;
  private Category category;

  @Getter
  public static class Category {
    private int id;
    private String name;
    private String image;
    private String creationAt;
    private String updatedAt;
  }
}
