package main.java.com.example.oop_battle;


enum Characteristic {
  WATER(1, "Water"), 
  EARTH(2, "Earth"), 
  WOOD(3, "Wood"),
  METAL(4, "Metal"),
  FIRE(5, "Fire"), 
  
  LIGHT(8, "Light"), 
  DARK(9, "Dark"),
  ;

  public int id;
  public String name;

  Characteristic(int id, String name) {
      this.id = id;
      this.name = name;
  }

  public int getId() {
      return id;
  }

  public String getName() {
      return name;
  }
}


