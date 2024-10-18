import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
  private Character player;
  private List<EnemyClass> enemies;

  public Game() {
    this.enemies = new ArrayList<>();
  }

  public Game(Character player) {
    this.player = player;
    this.enemies = new ArrayList<>();
  }

  public void startNewGame() {
    initializeEnemies();
  }

  private void initializeEnemies() {
    enemies.clear();
    enemies.add(new Goblin());
  }

  public Character getPlayer() {
    return player;
  }

  public EnemyClass getEnemy() {
    if (!enemies.isEmpty()) {
      return enemies.get(0); // Simple example: get the first enemy
    }
    return null; // No enemies available
  }

  public List<EnemyClass> getEnemies() {
    return new ArrayList<>(enemies); // Return a copy to avoid external modifications
  }

  public void displayEnemyCount() {
    System.out.println("Number of Enemies: " + enemies.size());
  }

  public void displayPlayerStats() {
    CharacterClass playerClass = player.getCharacterClass();
    System.out.println(playerClass + " Stats: ");
    System.out.println("\tName: " + player.getName());
    System.out.println("\tLevel: " + player.getLevel());
    System.out.println("\tStrength: " + playerClass.getStrength());
    System.out.println("\tAgility: " + playerClass.getAgility());
    System.out.println("\tIntelligence: " + playerClass.getIntelligence());
    System.out.println("\tHealth: " + playerClass.getHealth());
  }

  public void displayWeaponStats() {
    Weapon weapon = player.getCharacterClass().getWeapon();
    System.out.println(weapon + " Stats: ");
    System.out.println("\t" + weapon.getDamageDescription());
  }

  public void displayEnemyStats() {
    if (enemies.isEmpty()) {
      System.out.println("There are no enemies to display.");
      return;
    }
    System.out.println("Enemy Stats: ");
    for (EnemyClass enemy : enemies) {
      System.out.println("\t" + enemy + ": " + enemy.getStats());
      System.out.println("\t" + "Monster Level: " + enemy.getMonsterLevel());
      if (enemy instanceof Goblin) {
        Goblin goblin = (Goblin) enemy;
        System.out.println("\tWielding: " + goblin.getWeapon());
        System.out.println("\t" + goblin.getWeapon().getDamageDescription());
      }
    }
  }

  public double rollDice(int playerLevel) {
    Random random = new Random();
    double baseMultiplier = 0.1;
    double maxMultiplier = baseMultiplier + (playerLevel - 1) * 0.05; // increase by 5% level
    // Generate a random value within the range [baseMultiplier, maxMultiplier]
    // random.nextDouble() method generates a random double between 0.0 and 1.0.
    // This value is then scaled to fall within the range from baseMultiplier to
    // maxMultiplier.
    double roll = baseMultiplier + (maxMultiplier - baseMultiplier) * random.nextDouble();
    return roll;
  }

  public int calculateAttackDamage(int playerLevel) {
    double diceRollMultiplier = rollDice(playerLevel);
    int basicAttackDamage = player.getCharacterClass().basicAttack();

    // Debugging information
    // System.out.println("Dice Roll Multiplier: " + diceRollMultiplier);
    // System.out.println("Basic Attack Damage: " + basicAttackDamage);

    double enhancedAttack = (basicAttackDamage * (1 + diceRollMultiplier));
    // System.out.println("Enhanced Attack Damage: " + enhancedAttack);
    return (int) Math.round(enhancedAttack);
  }

  public void attackEnemy(EnemyClass enemy) {
    int damage = calculateAttackDamage(player.getLevel()); 
    System.out.println("You dealth " + damage + " damage to the enemy!");
    enemy.receiveDamage(damage); // Apply damage

    System.out.println("Enemy's remaining health " + enemy.getHealth());
    // Use the isAlive method 
    if (!enemy.isAlive() || enemy.getHealth() <= 0) {
      System.out.println("Enemy Defeated!");
      awardXP();
    }
  }
  
  //award xp to player
  public void awardXP() {
    int xpGained = 50;
    System.out.println("You gained " + xpGained + " xp for defeating enemy!");
    player.addXP(xpGained);
  }

  //enemy's turn
  public void enemyTurn() { 
    EnemyClass enemy = getEnemy();
    if ( enemy != null && enemy.isAlive()) {
      int enemyAttackDamage = enemy.basicAttack();
      System.out.println("The enemy attacks you for " + enemyAttackDamage + " damage!");
      player.receiveDamage(enemyAttackDamage);

      if (player.getCharacterClass().getHealth() <=0) {
        System.out.println("You have been defeated!");
      } else {
        System.out.println("Your remaining health: " + player.getCharacterClass().getHealth());
      }
    } 
  }
}