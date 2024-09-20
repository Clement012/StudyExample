package com.example.diy.shoppingcart.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.diy.shoppingcart.controller.StoreAOperation;
import com.example.diy.shoppingcart.controller.StoreBOperation;
import com.example.diy.shoppingcart.model.storeA.StoreAType;
import com.example.diy.shoppingcart.model.storeB.StoreBStock;

@Controller
public class FrontPageController {

  @Autowired
  private StoreAOperation storeAOperation;

  @Autowired
  private StoreBOperation storeBOperation;
  
  @GetMapping(value = "/")
  public String frontpage(Model model) {
      List<StoreAType> atypes = storeAOperation.getTypes();
      model.addAttribute("atypes", atypes);
      List<StoreBStock> btypes = storeBOperation.getStocks();
      categorizeItems(btypes, model);
      return "Frontpage";
  }

  private void categorizeItems(List<StoreBStock> btypes, Model model) {
      List<StoreBStock> mensClothes = new ArrayList<>();
      List<StoreBStock> womensClothes = new ArrayList<>();
      List<StoreBStock> jewelery = new ArrayList<>();
      List<StoreBStock> electronics = new ArrayList<>();

      // Categorize the items
      for (StoreBStock item : btypes) {
          switch (item.getCategory()) {
              case "men's clothing" -> mensClothes.add(item);
              case "women's clothing" -> womensClothes.add(item);
              case "jewelery" -> // Corrected spelling
              jewelery.add(item);
              case "electronics" -> electronics.add(item);
          }
      }

      // Shuffle each category list for randomness
      Collections.shuffle(mensClothes);
      Collections.shuffle(womensClothes);
      Collections.shuffle(jewelery);
      Collections.shuffle(electronics);

      // Add categorized lists to the model
      model.addAttribute("mensClothes", mensClothes);
      model.addAttribute("womensClothes", womensClothes);
      model.addAttribute("jewelery", jewelery);
      model.addAttribute("electronics", electronics);

      // Add the first random items from each category if available
      if (!mensClothes.isEmpty()) {
          model.addAttribute("randomMens", mensClothes.get(0));
      }
      if (!womensClothes.isEmpty()) {
          model.addAttribute("randomWomens", womensClothes.get(0));
      }
      if (!jewelery.isEmpty()) {
          model.addAttribute("randomJewelery", jewelery.get(0));
      }
      if (!electronics.isEmpty()) {
          model.addAttribute("randomElectronics", electronics.get(0));
      }
  }
}

