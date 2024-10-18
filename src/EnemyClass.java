public abstract class EnemyClass extends CharacterClass {
  private int monsterLevel;

  public EnemyClass() {
    super();
    this.monsterLevel = 1;
  }

  public EnemyClass(int strength, int agility, int intelligence, int health, int monsterLevel, Weapon weapon) {
    super(strength, agility, intelligence, health, weapon);
    this.monsterLevel = monsterLevel;
  }

  public int getMonsterLevel() {
    return this.monsterLevel;
  }

  public void setMonsterLevel(int level) {
    this.monsterLevel = level;
  }

  public String getStats() {
    return "Strength: " + getStrength() + ", Agility: " + getAgility() + ", Intelligence: " + getIntelligence() + ", Health: " + getHealth();
  }
  
}