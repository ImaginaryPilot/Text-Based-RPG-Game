package nl.rug.oop.rpg.interfaces;

/**
 * The Attackable interface.
 */
public interface Attackable {
    /**
     * Reduce damage.
     *
     * @param damage the damage taken
     * @return true if the object is still alive, false otherwise
     */
    boolean reduceHealth(int damage);

    /**
     * Reduce damage.
     * This method is used for the combat system.
     * @param damage the damage taken. This is the damage that will be reduced by the combat system.
     * @return true if the object is still alive, false otherwise.
     */
    boolean reduceCombatHealth(int damage);

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
