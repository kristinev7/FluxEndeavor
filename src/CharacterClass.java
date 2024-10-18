public abstract class CharacterClass implements Health {
  private int strength;
  private int agility;
  private int intelligence;
  private int health;
  private Weapon weapon;

  public CharacterClass() {
    this.strength = 0;
    this.agility = 0;
    this.intelligence = 0;
    this.health = 100;
    this.weapon = null;
  }

  public CharacterClass(int strength, int agility, int intelligence, int health, Weapon weapon) {
    this.strength = strength;
    this.agility = agility;
    this.intelligence = intelligence;
    this.health = health;
    this.weapon = weapon;
  }

  // getters
  public int getStrength() {
    return this.strength;
  }

  public int getAgility() {
    return this.agility;
  }

  public int getIntelligence() {
    return this.intelligence;
  }

  public int getHealth() {
    return this.health;
  }

  public Weapon getWeapon() {
    return this.weapon;
  }

  // setters
  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setAgility(int agility) {
    this.agility = agility;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public int basicAttack() {
    if (weapon != null) {
      return weapon.basicAttack();
    }
    return 0;
  }

  public int specialAttack() {
    if (weapon != null) {
      return weapon.specialAttack(); 
    }
    return 0;
  }
  
  public void receiveDamage(int damage) {
    this.health -= damage;
    if (this.health < 0) {
      this.health = 0;
    }
  }

  public void heal(int amount) {
    this.health += amount;
  }
  
  public boolean isAlive() {
    return this.health > 0;
  }
  
}