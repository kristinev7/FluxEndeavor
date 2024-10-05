public class Character { 
  private String name;
  private int level;
  private CharacterClass characterClass;
  private Weapon weapon;

  public Character() {
    this.name = "";
    this.level = 1;
    this.characterClass = new Warrior();
    this.weapon = new Sword();
  }

  public Character(String name, int level, CharacterClass characterClass, Weapon weapon) {
    this.name = name;
    this.level = level;
    this.characterClass = characterClass;
    this.weapon = weapon;
  }

  // getter
  public String getName() {
    return this.name;
  }

  public int getLevel() {
    return this.level;
  }

  public CharacterClass getCharacterClass() {
    return this.characterClass;
  }

  public Weapon getWeapon() {
    return this.weapon;
  }

  // setter
  public void setName(String name) {
    if (name != null) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Name cannot be null");
    }
  }

  public void setLevel(int level) {
    if ( level >= 0) {
      this.level = level;
    } else {
      throw new IllegalArgumentException("Level cannot be negative");
    }
  }

  public void setCharacterClass(CharacterClass characterClass) {
    this.characterClass = characterClass;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  // player receives damage
  // @Override
  public void receiveDamage(int damage) {
    this.characterClass.receiveDamage(damage);
    if (!this.characterClass.isAlive()) {
      deathMessage();
    }
  }

  public void deathMessage() {
    System.out.println("You have died");
  }

}