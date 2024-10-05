public class MagicalStaff extends Weapon {
  private int mysticStrike = 6;
  private int etherStorm = 13;

  @Override
  public int basicAttack() {
    return mysticStrike;
  }

  @Override
  public int specialAttack() {
    return etherStorm;
  }

  @Override
  public String getDamageDescription() {
    return "Magical Staff - Mystic Strike: " + mysticStrike + ", Ether Storm: " + etherStorm;
  }

  @Override
  public String toString() {
    return "Magical Staff";
  }
}
