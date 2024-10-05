public class Mage extends CharacterClass {
  
  public Mage() {
    super(5, 20, 15, 100);
  }

  public Mage(int strength, int agility, int intelligence, int health) {
    super(strength, agility, intelligence, health);
  }
  
  @Override
  public String toString() {
    return "Mage";
  }
}
// need to add mage specific attributes