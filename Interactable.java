package nl.rug.oop.rpg;

/**
 * The Interactable interface.
 */
public interface Interactable {
    /**
     * Interact with the object.
     * @param player the player who interacts
     */
    void interact(Player player);
}
