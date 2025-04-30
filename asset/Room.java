package nl.rug.oop.rpg.asset;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.interfaces.Inspectable;
import nl.rug.oop.rpg.npc.NPC;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
/**
 * The room class.
 */
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
    private List<NPC> npcs;

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
        this.npcs = new ArrayList<>();
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
        npcs.add(npc);
    }

    /**
     * Get the NPCs in the room.
     *
     * @return the NPCs in a list
     */
    public List<NPC> getNPCs() {
        return npcs;
    }

    /**
     * Remove all dead NPCs from the room.
     */
    public void removeDeadNPCs(){
        npcs.removeIf(npc -> !npc.isAlive());
    }
}
