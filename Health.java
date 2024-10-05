public interface Health {
  void receiveDamage(int damage);
  void heal(int amount);
  boolean isAlive();
}
