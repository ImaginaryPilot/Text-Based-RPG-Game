package nl.rug.oop.rpg.interfaces;

/**
 * The Attackable interface.
 */
public interface Attackable {
    /**
     * Take damage.
     *
     * @param damage the damage taken
     * @return true if the object is still alive, false otherwise
     */
    boolean takeDamage(int damage);

    /**
     * Get the health of the object.
     *
     * @return health
     */
    int getHealth();

    /**
     * Check if the object is alive.
     *
     * @return true if the object is alive, false otherwise
     */
    boolean isAlive();

    /**
     * Handle the object's death.
     */
    void onDeath();
}
