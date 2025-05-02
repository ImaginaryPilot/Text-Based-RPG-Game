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
public abstract class Item implements Inspectable, Interactable {
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
        System.out.println("interacted without override");
    }

    /**
     * Delete the item from the player's inventory.
     * @param player the player who deletes the item from the inventory.
     */
    public void deleteFromInventory(Player player){
        player.getInventory().removeItem(this);
    }

    /**
     * Drop the item.
     *
     * @param player the player who drops the item
     */
    public void drop(Player player) {
        player.getInventory().removeItem(this);
        player.getCurrentRoom().addItem(this);
        System.out.println("You dropped the " + name + ".");
    }

    /**
     * Pick up the item.
     *
     * @param player the player who picks up the item
     */
    public void pickup(Player player) {
        if (!player.getInventory().addItem(this)) {
            System.out.println("You couldn't pick up the " + name + ", because your backpack is full.");
            System.out.println("You can drop or use an item from your backpack to pick up new items.");
        } else {
            player.getCurrentRoom().removeItem(this);
            System.out.println("You picked up the " + name + ".");
        }
    }
}
