import java.util.Random;
public class Goblin extends EnemyClass {
  private Weapon weapon;
  
  public Goblin() {
    super(6, 8, 9, 100, 1);
    this.weapon = randomWeapon();
  }

  public Goblin(int strength, int agility, int intelligence, int health, int monsterLevel, Weapon weapon) {
    super(strength, agility, intelligence, health, monsterLevel);
    this.weapon = weapon;
  }
  
  private Weapon randomWeapon() {
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

  public Weapon getWeapon() {
    return this.weapon;
  }
  
  @Override
  public String toString() {
    return "Goblin";
  }
}