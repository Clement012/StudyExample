package main.java.com.example.oop_battle;

public enum Characteristic {
  METAL(1, "Metal"),
  WOOD(2, "Wood"),
  WATER(3, "Water"), 
  FIRE(4, "Fire"), 
  EARTH(5, "Earth"), 
  LIGHT(8, "Light"), 
  DARK(9, "Dark"),
  ;

  private final int id;
  private final String name;

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

  public int applyBonus(int attack) {
      if (this.id % 2 != 0) {
          return (int) (attack * 1.5);
      }
      return attack;
  }
}


