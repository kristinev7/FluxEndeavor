import java.util.Random;
public class Goblin extends EnemyClass {
  
  public Goblin() {
    super(15, 15, 15, 100, 1, randomWeapon());
  }

  public Goblin(int strength, int agility, int intelligence, int health, int monsterLevel, Weapon weapon) {
    super(strength, agility, intelligence, health, monsterLevel, weapon);
  }
  
  private static Weapon randomWeapon() {
    Random random = new Random();
    int choice = random.nextInt(3);
    switch (choice) {
      case 0:
        return new Sword(); 
      case 1:
        return new MagicalStaff();
      case 2:
        return new Bow();
      default:
        return new Sword();
    }
  }

  @Override
  
  public int basicAttack() {
    int weaponDamage = getWeapon().basicAttack();
    int attackPower = getStrength() + weaponDamage;
    System.out.println("Goblin attacks with " + getWeapon() + " for " + attackPower + " damage!");
    return attackPower;
  }

  @Override
  public int specialAttack() {
    int weaponDamage = getWeapon().specialAttack();
    int attackPower = getStrength() + weaponDamage;
    System.out.println("Goblin uses a special attack with " + getWeapon() + " for " + attackPower + " damage!");
    return attackPower;
  }
  
  @Override
  public String toString() {
    return "Goblin";
  }
}