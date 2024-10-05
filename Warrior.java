public class Warrior extends CharacterClass {
  
  public Warrior() {
    super(18, 10, 5, 100);
  }

  public Warrior(int strength, int agility, int intelligence, int health) {
    super(strength, agility, intelligence, health);
  }

  @Override
  public String toString() {
    return "Warrior";
  }
}

// need to add warrior specific attributes