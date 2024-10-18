public class Mage extends CharacterClass {
  
  public Mage() {
    super(10, 10, 15, 100, new MagicalStaff());
  }

  public Mage(int strength, int agility, int intelligence, int health, Weapon weapon) {
    super(strength, agility, intelligence, health, weapon);
  }
  
  @Override
  public String toString() {
    return "Mage";
  }

  @Override
    public int basicAttack() {
      int weaponDamage = getWeapon().basicAttack();
      int attackPower = getIntelligence() + weaponDamage;
      return attackPower;
    }

    @Override
    public int specialAttack() {
      int weaponDamage = getWeapon().specialAttack();
      int attackPower = getIntelligence() + weaponDamage;
      return attackPower;
    }
}
// need to add mage specific attributes 