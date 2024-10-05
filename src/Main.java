
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Test;
// @Test
// void addition() {
//     assertEquals(2, 1 + 1);
// }
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Flux Endeavor! Let's Play!");
    String playerName = getCharName(scanner);
    CharacterClass characterClass = chooseCharacterClass(scanner);
    Weapon weapon = chooseWeapon(scanner);

    Character player = new Character(playerName, 1, characterClass, weapon);

    Game game = new Game(player);
    game.startNewGame();
    game.displayPlayerStats();
    game.displayWeaponStats();
    game.displayEnemyCount();
    game.displayEnemyStats();
    System.out.println();
    System.out.println("Let the battle begin!");

    int playerLevel = player.getLevel();
    Weapon weaponChosen = game.getPlayer().getWeapon();
    System.out.println(weaponChosen + " basic attack: " + weaponChosen.basicAttack());
    
    int attackDamage = increaseDamage(game, scanner, playerLevel);
    System.out.println("New Basic Attack Damage: " + attackDamage);
    System.out.println("Attack Now: (1) Attack!");
    
    
  }

  private static String getCharName(Scanner scanner) {
  String playerName;
  boolean validName = false;
  // Keep asking for the player's name until a valid name is entered
  do {
      System.out.println("Enter your character's name: ");
      playerName = scanner.nextLine();

      // Validate the player's name using a regular expression
      if (playerName.matches("\\A[A-Za-z]*\\z")) {
          System.out.println("Welcome " + playerName + "!");
          validName = true;  // Set the flag to true to exit the loop
      } else {
          System.out.println("Invalid name. Please enter a valid name.");
      }
  } while (!validName);  // Continue looping until a valid name is entered

    return playerName;
  }
  
  private static int increaseDamage(Game game, Scanner scanner, int playerLevel) {
    System.out.println("Roll dice to increase attack damage against enemy: (1) Roll (2) Skip");
    int rollChoice = scanner.nextInt();
    scanner.nextLine();
    Weapon weapon = game.getPlayer().getWeapon();
    switch (rollChoice) {
      case 1: 
        return game.calculateAttackDamage(playerLevel);
      case 2:
        return weapon.basicAttack();
      default:
        System.out.println("Invalid choice. Skipping roll.");
        return weapon.basicAttack();
    }
  }
  private static CharacterClass chooseCharacterClass(Scanner scanner) {
    System.out.println("Choose your character class (1) Warrior (2) Mage (3) Ranger");
    int classChoice = scanner.nextInt();
    switch (classChoice) {
      case 1:
        return new Warrior();
      case 2:
        return new Mage();
      case 3:
        return new Ranger();
      default:
        System.out.println("Invalid choice, defaulting to Warrior");
        return new Warrior();
    }
  }

  private static Weapon chooseWeapon(Scanner scanner) {
    System.out.println("Choose your weapon (1) Sword (2) Magical Staff (3) Bow");
    int weaponChoice = scanner.nextInt();
    switch (weaponChoice) {
      case 1:
        return new Sword();
      case 2:
        return new MagicalStaff();
      case 3:
        return new Bow();
      default:
        System.out.println("Invalid choice, defaulting to Sword.");
        return new Sword();
    }

  }

  // private static int attackPhase(Scanner scanner) {
    
  // }

}