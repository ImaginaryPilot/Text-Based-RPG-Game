package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

public class Room implements Inspectable{
    private String name;
    private String description;
    private List<Door> doors;
    private List<NPC> npcs;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.doors = new ArrayList<>();
        this.npcs = new ArrayList<>();
    }

    @Override
    public void inspect() {
        System.out.println(description + " The room has " + doors.size() + " door(s).");
    }

    public void addDoor(Door door){
        doors.add(door);
    }

    public void addNPC(NPC npc){
        npcs.add(npc);
    }

    public List<NPC> getNPCS(){
        return npcs;
    }

    public List<Door> getDoors() {
        return doors;
    }
}
