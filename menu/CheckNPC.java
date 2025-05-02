package nl.rug.oop.rpg.menu;

import nl.rug.oop.rpg.asset.Room;
import nl.rug.oop.rpg.interfaces.Attackable;
import nl.rug.oop.rpg.npc.NPC;
import nl.rug.oop.rpg.player.Player;

import java.util.Scanner;
import java.util.Random;

/**
 * The CheckNPC class.
 */
public final class CheckNPC {
    /**
     * Random variable generator.
     */
    private static final Random RAND = new Random();

    /**
     * Check if there is an NPC in the current room.
     *
     * @param player  the player to interact with the NPC
     * @param scanner the scanner
     */
    public static void checkNPC(Player player, Scanner scanner) {
        Room currentRoom = player.getCurrentRoom();
        System.out.println("You look if there’s someone here.");
        System.out.println("You see:");
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            NPC npc = currentRoom.getNPCs().get(i); // Get the npc from the list
            System.out.println(" (" + i + ") " + npc.getDescription());
        }
        System.out.println("Interact ? (-1 : do nothing)");
        int choice = scanner.nextInt();
        if (choice != -1) {
            if (choice < currentRoom.getNPCs().size()) {
                NPC npc = currentRoom.getNPCs().get(choice);
                handleNPCInteraction(npc, player, scanner);
            } else {
                System.out.println("There is no NPC at this location.");
            }
        }
    }

    /**
     * Handle the interaction with an NPC.
     *
     * @param npc     the NPC to interact with
     * @param player  the player
     * @param scanner the scanner
     */
    public static void handleNPCInteraction(NPC npc, Player player, Scanner scanner) {
        boolean keepInteracting = true;
        int choice = 0;
        while (keepInteracting) {
            System.out.println("What do you want to do with " + npc.getDescription() + "?");
            System.out.println(" (0) Interact");
            System.out.println(" (1) Attack");
            System.out.println(" (2) Ignore");
            System.out.println(" (3) Quit interaction");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    npc.interact(player);
                    break;
                case 1:
                    if (npc instanceof Attackable target) {
                        boolean targetSurvived = player.attack(target);
                        if (!targetSurvived) {
                            int amount = 8 + RAND.nextInt(3); // 8 - 10 coin
                            player.getMoney(amount);
                            keepInteracting = false;
                        }
                    } else {
                        System.out.println("This NPC is not attackable.");
                    }
                    break;
                case 2:
                    System.out.println("NPC doesn't like to be ignored!");
                    npc.attack(player);
                    break;
                case 3:
                    keepInteracting = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
