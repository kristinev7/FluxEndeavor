public class Warrior extends CharacterClass {
  
  public Warrior() {
    super(15, 10, 10, 100, new Sword());
  }

  public Warrior(int strength, int agility, int intelligence, int health, Weapon weapon) {
    super(strength, agility, intelligence, health, weapon);
  }

  @Override
  public String toString() {
    return "Warrior";
  }

  @Override
  public int basicAttack() {
    int weaponDamage = getWeapon().basicAttack();
    int attackPower = getStrength() + weaponDamage;
    return attackPower;
  }

  @Override
  public int specialAttack() {
    int weaponDamage = getWeapon().specialAttack();
    int attackPower = getStrength() + weaponDamage;
    return attackPower;
  }
}

// need to add warrior specific attributes 