public class Ranger extends CharacterClass {

  public Ranger() {
    super(10, 15, 10, 100, new Bow());
  } 

  public Ranger(int strength, int agility, int intelligence, int health, Weapon weapon) {
    super(strength, agility, intelligence, health, weapon);
  }
  
  @Override
  public String toString() {
    return "Ranger";
  }

  @Override
    public int basicAttack() {
      int weaponDamage = getWeapon().basicAttack();
      int attackPower = getAgility() + weaponDamage;
      return attackPower;
    }

    @Override
    public int specialAttack() {
      int weaponDamage = getWeapon().specialAttack();
      int attackPower = getAgility() + weaponDamage;
      return attackPower;
    }
}
// need to add ranger specific attributes 