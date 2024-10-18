public class Bow extends Weapon {
  private int piercing = 5;
  private int barrage = 10;

  @Override
  public int basicAttack() { 
    return piercing;
  }

  @Override
  public int specialAttack() {
    return barrage;
  }

  @Override
  public String getDamageDescription() {
    return "Bow - Piercing: " + piercing + ", Barrage: " + barrage;
  }

  @Override
  public String toString() {
    return "Bow";
  }
}