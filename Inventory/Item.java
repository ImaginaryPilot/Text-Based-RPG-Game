package nl.rug.oop.rpg.Inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.rug.oop.rpg.interfaces.Inspectable;
import nl.rug.oop.rpg.interfaces.Interactable;
import nl.rug.oop.rpg.player.Player;

/**
 * Item class.
 */
@Data
@AllArgsConstructor
public class Item implements Inspectable, Interactable {
    /**
     * Item name.
     */
    private String name;
    /**
     * Item description.
     */
    protected String description;
    /**
     * Item effect.
     */
    private String effect;

    @Override
    public void inspect() {
        System.out.println(description);
    }

    @Override
    public void interact(Player player) {

    }
}
