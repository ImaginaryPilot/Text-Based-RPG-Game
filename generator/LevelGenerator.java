package nl.rug.oop.rpg.generator;

import nl.rug.oop.rpg.Inventory.DefenseAdditiveItem;
import nl.rug.oop.rpg.Inventory.Item;
import nl.rug.oop.rpg.asset.Door;
import nl.rug.oop.rpg.asset.Room;
import nl.rug.oop.rpg.npc.Enemy;
import nl.rug.oop.rpg.npc.NPC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The LevelGenerator class.
 */
public class LevelGenerator {
    /**
     * The room names.
     */
    private static final String[] ROOM_NAMES = {
            "Hall", "Corridor", "Cave", "Dungeon", "Chamber", "Balcony", "Diner", "Armory"};
    /**
     * The room descriptions.
     */
    private static final String[] ROOM_DESCRIPTIONS = {
            "A damp and eerie space.",
            "A room lined with flickering torches.",
            "Filled with whispers of past adventurers.",
            "Contains walls scratched by unknown claws.",
            "A space that smells like sulfur and fear.",
            "A view too cramped to be called pleasant",
            "Stacked with remnants of past dwellers",
            "Filled with nothing but rotting and empty artifacts"
    };

    /**
     * The enemies.
     */
    private static final String[] ENEMIES = {"Goblin", "Wraith", "Skeleton", "Bandit", "Slime"};

    /**
     * The random number generator.
     */
    private static Random rand = new Random();

    /**
     * Generate rooms.
     *
     * @param count      the number of rooms to generate
     * @param startRoom  the start room
     * @param goalRoom   the goal room
     * @param traderRoom the trader room
     * @return the list of rooms
     */
    public static List<Room> generateRooms(int count, Room startRoom, Room goalRoom, Room traderRoom) {
        List<Room> rooms = new ArrayList<>();
        List<String> availableNames = new ArrayList<>(List.of(ROOM_NAMES));
        Collections.shuffle(availableNames); // Shuffle names to randomize

        rooms.add(startRoom);
        generateNPCsForRoom(startRoom);

        for (int i = 0; i < count; i++) {
            String name = availableNames.get(i);
            String desc = ROOM_DESCRIPTIONS[rand.nextInt(ROOM_DESCRIPTIONS.length)];
            Room room = new Room(name, desc);

            generateNPCsForRoom(room);
            rooms.add(room);
        }
        rooms.add(goalRoom);

        // Link rooms with doors
        for (int i = 0; i < rooms.size() - 1; i++) {
            Room current = rooms.get(i);
            Room next = rooms.get(i + 1);

            current.addDoor(new Door(next, "A door to " + next.getName()));
            next.addDoor(new Door(current, "A door back to " + current.getName())); // Optional backtracking
        }
        generateItemsForRoom(startRoom);
        return rooms;
    }

    /**
     * Generate NPCs for a room.
     *
     * @param room the room to generate NPCs for
     */
    private static void generateNPCsForRoom(Room room) {
        int numNPCs = 1 + rand.nextInt(3); // 1 to 3 NPCs per room

        for (int i = 0; i < numNPCs; i++) {
            if (rand.nextBoolean()) {
                room.addNPC(new NPC("Wandering traveler", 100, 5));
            } else {
                String enemyName = ENEMIES[rand.nextInt(ENEMIES.length)];
                int health = 20 + rand.nextInt(21); // 20–40 HP
                int damage = 5 + rand.nextInt(6);   // 5–10 DMG
                room.addNPC(new Enemy(enemyName, health, damage));
            }
        }
    }

    private static void generateItemsForRoom(Room room) {
        Item item = new DefenseAdditiveItem("defending brick", "Something of a description", "whatever an effect is", "You just used some brick", 10);
        Item secondItem = new DefenseAdditiveItem("defending stone", "Something of stone descriptno", "whatever an effect is","Proud to use stone?", 10);
        Item thirdItem = new DefenseAdditiveItem("defending grass", "Something of grass stone", "whatever an effect is", 10);

        room.addItem(item);
        room.addItem(secondItem);
        room.addItem(thirdItem);
    }

}
