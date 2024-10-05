public class Sword extends Weapon {
  private int slash = 5;
  private int phoenixSlash = 14;

  @Override
  public int basicAttack() {
    return slash;
  }

  @Override
  public int specialAttack() {
    return phoenixSlash;
  }

  @Override
  public String getDamageDescription() {
    return "Sword - Slash: " + slash + ", Phoenix Slash: " + phoenixSlash;
  }

  @Override
  public String toString() {
    return "Sword";
  }
}