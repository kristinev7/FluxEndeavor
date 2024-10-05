public class Ranger extends CharacterClass {

  public Ranger() {
    super(12, 15, 8, 100);
  } 

  public Ranger(int strength, int agility, int intelligence, int health) {
    super(strength, agility, intelligence, health);
  }
  
  @Override
  public String toString() {
    return "Ranger";
  }
}
// need to add ranger specific attributes