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
    Weapon weapon = player.getWeapon();
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
    Weapon weapon = player.getWeapon();
    int basicAttackDamage = weapon.basicAttack();

    // Debugging information
    System.out.println("Dice Roll Multiplier: " + diceRollMultiplier);
    System.out.println("Basic Attack Damage: " + basicAttackDamage);

    double enhancedAttack = (basicAttackDamage * (1 + diceRollMultiplier));
    System.out.println("Enhanced Attack Damage: " + enhancedAttack);
    return (int) Math.round(enhancedAttack);
  }

  public void attackEnemy(EnemyClass enemy) {
    int damage = calculateAttackDamage(player.getLevel()); 
    // Determine damage based on player's stats, weapon, etc.
    enemy.receiveDamage(damage); // Apply damage

    // Use the isAlive method if you've included it in the Health interface
    if (!enemy.isAlive()) {
      System.out.println("Enemy Defeated!");
      // Handle post-defeat logic here (e.g., remove enemy, update game state, award
      // XP)
    }

    // Or directly check health
    if (enemy.getHealth() <= 0) {
      System.out.println("Enemy Defeated!");
      // Similar post-defeat logic as above
    }
  }

  public void enemyTurn() {

  }
}