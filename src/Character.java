public class Character { 
  private String name;
  private int level;
  private CharacterClass characterClass; 
  private int currentXP;
  private int xpForNextLevel;

  public Character() {
    this.name = "";
    this.level = 1;
    this.characterClass = new Warrior();
    this.currentXP = 0;
    this.xpForNextLevel = 100;
  }

  public Character(String name, int level, CharacterClass characterClass) {
    this.name = name;
    this.level = level;
    this.characterClass = characterClass;
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

  public int getCurrenctXP() {
    return this.currentXP;
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

  // player or enemy receives damage
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
  
  // leveling up player
  public void addXP(int xp) {
    this.currentXP += xp;
    checkLevelUp();
  }

  public void checkLevelUp() {
    if (currentXP >= xpForNextLevel) {
      levelUp();
    }
  }

  private void levelUp() {
    level++;
    currentXP -= xpForNextLevel; //carry over remaining xp to next level
    xpForNextLevel = 100 * level;

    // increasing level of other characteristics
    characterClass.setStrength(characterClass.getStrength() + 5);
    characterClass.setAgility(characterClass.getAgility() + 3);
    characterClass.setIntelligence(characterClass.getIntelligence() +2);

    System.out.println("level up! New Level: " + level);
    System.out.println("New Stats -> Strength: " + characterClass.getStrength() + ", Agility: " + characterClass.getAgility() + ", Intelligence: " + characterClass.getIntelligence());
  }
}