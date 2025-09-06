package nl.rug.oop.rpg.player;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.Inventory.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * The inventory class.
 */
@Getter
@Setter
public class Inventory {
    /**
     * The default maximum capacity of the inventory.
     */
    private static final int DEFAULT_MAXCAPACITY = 2;
    /**
     * The default gold in the inventory.
     */
    private static final int DEFAULT_GOLD = 0;
    /**
     * The items in the inventory.
     */
    private List<Item> items;
    /**
     * The maximum capacity of the inventory.
     */
    private int maxCapacity;
    /**
     * The gold in the inventory.
     */
    private int gold;

    /**
     * Constructor Inventory.
     */
    public Inventory() {
        this.items = new ArrayList<>();
        this.maxCapacity = DEFAULT_MAXCAPACITY;
        this.gold = DEFAULT_GOLD;
    }

    /**
     * Add an item to the inventory.
     * @param item The item to add.
     * @return true if the item was added, false otherwise.
     */
    public boolean addItem(Item item) {
        if (items.size() < maxCapacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Remove an item from the inventory.
     * @param item The item to remove.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Add gold to the inventory.
     * @param gold The amount of gold to add.
     */
    public void addGold(int gold) {
        this.gold += gold;
    }

    /**
     * Remove gold from the inventory.
     * @param gold The amount of gold to remove.
     * @return true if the gold was removed, false otherwise.
     */
    public boolean removeGold(int gold) {
        if (this.gold >= gold) {
            this.gold -= gold;
            return true;
        } else {
            return false;
        }
    }

}
