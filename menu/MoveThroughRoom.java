package nl.rug.oop.rpg.menu;

import nl.rug.oop.rpg.asset.Door;
import nl.rug.oop.rpg.asset.Room;
import nl.rug.oop.rpg.player.Player;
import java.util.Scanner;

public final class MoveThroughRoom {
    public static void moveThroughRoom (Player player, Scanner scanner) {
        Room currentRoom = player.getCurrentRoom();
        System.out.println("You look around for doors.");
        System.out.println("You see:");
        for (int i = 0; i < currentRoom.getDoors().size(); i++) {
            Door door = currentRoom.getDoors().get(i); // Get the door from the list
            System.out.println(" (" + i + ") " + door.getDoorDescription());
        }
        System.out.println("Which door do you take? (-1 : stay here)");
        int choice = scanner.nextInt();
        if (choice != -1) {
            System.out.println("You go through the door");
            Door door = currentRoom.getDoors().get(choice);
            door.interact(player);
        }
    }
}
