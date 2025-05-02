package nl.rug.oop.rpg.menu;

import nl.rug.oop.rpg.asset.Room;
import nl.rug.oop.rpg.player.Player;

import java.util.Scanner;

/**
 * The MoveToTraderRoom class.
 */
public class MoveToTraderRoom {
    /**
     * Move to the trader room from the current room.
     * @param player the player
     * @param traderRoom the trader room
     * @param scanner the scanner
     */
    public static void moveToTraderFrom(Player player, Room traderRoom, Scanner scanner) {
        boolean trader = true;
        Room previousRoom = player.getCurrentRoom();
        player.setCurrentRoom(traderRoom);

        while(trader){
            System.out.println("You have " + player.getMoney() + " coins.");
            System.out.println("What would you like to buy/trader?");
            System.out.println(" (_) __");
            System.out.println(" (1) Return?");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    trader = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        player.setCurrentRoom(previousRoom);
    }
}