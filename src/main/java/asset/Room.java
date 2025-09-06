package nl.rug.oop.rpg.asset;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.Inventory.Item;
import nl.rug.oop.rpg.interfaces.Inspectable;
import nl.rug.oop.rpg.npc.NPC;

import java.util.ArrayList;
import java.util.List;

/**
 * The room class.
 */
@Getter
@Setter
public class Room implements Inspectable {
    /**
     * The name of the room.
     */
    private String name;
    /**
     * The description of the room.
     */
    private String description;
    /**
     * The doors in the room.
     */
    private List<Door> doors;
    /**
     * The NPCs in the room.
     */
    private List<NPC> NPCs;
    /**
     * The items in the room.
     */
    private List<Item> items;

    /**
     * Constructor Room.
     *
     * @param name        the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.doors = new ArrayList<>();
        this.NPCs = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    /**
     * Inspect the room.
     */
    @Override
    public void inspect() {
        System.out.println(description + " The room has " + doors.size() + " door(s).");
    }

    /**
     * Add a door to the room.
     *
     * @param door the door
     */
    public void addDoor(Door door) {
        doors.add(door);
    }

    /**
     * Add an NPC to the room.
     *
     * @param npc the NPC
     */
    public void addNPC(NPC npc) {
        NPCs.add(npc);
    }

    /**
     * Remove all dead NPCs from the room.
     */
    public void removeDeadNPCs() {
        NPCs.removeIf(npc -> !npc.isAlive());
    }

    /**
     * Add an item to the room.
     * @param item the item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Remove an item from the room.
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
}
