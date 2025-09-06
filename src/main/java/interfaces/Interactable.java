package nl.rug.oop.rpg.interfaces;

import nl.rug.oop.rpg.player.Player;

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
