package nl.rug.oop.rpg.menu;

import nl.rug.oop.rpg.asset.Door;
import nl.rug.oop.rpg.asset.Room;
import nl.rug.oop.rpg.player.Player;

import java.util.Scanner;

public class MoveToTraderRoom {
    public static void moveToTraderFrom(Player player, Room traderRoom, Scanner scanner) {
        boolean trader = true;
        Room previousRoom = player.getCurrentRoom();
        player.setCurrentRoom(traderRoom);

        while(trader){
            System.out.println("What would you like to buy/trader?");
            System.out.println(" (_) __");
            System.out.println(" (1) Return?");

            int choice = scanner.nextInt();
            switch (choice){
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
