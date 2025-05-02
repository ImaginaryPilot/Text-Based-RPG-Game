package nl.rug.oop.rpg.menu;

import nl.rug.oop.rpg.Inventory.Item;
import nl.rug.oop.rpg.asset.Door;
import nl.rug.oop.rpg.player.Player;

import java.util.List;
import java.util.Scanner;

public class HandleInventory {
    public static void handleInventory(Player player, Scanner scanner) {
        List<Item> inventoryItems = player.getInventory().getItems();

        boolean keepInteracting = true;
        while (keepInteracting) {
            if (inventoryItems.isEmpty()) {
                System.out.println("You have no items in your inventory. Try to pick up something or buy something.");
                return;
            }
            System.out.println("Your inventory is:");
            for (int i = 0; i < inventoryItems.size(); i++) {
                Item item = inventoryItems.get(i);
                System.out.println(" (" + i + ") " + item.getName());
            }
            System.out.println("Interact ? (-1 : do nothing)");
            int choice = scanner.nextInt();
            if (choice == -1) {
                keepInteracting = false;
            } else if (choice < inventoryItems.size()) {
                Item item = inventoryItems.get(choice);
                boolean keepItemInteracting = true;
                while (keepItemInteracting) {
                    System.out.println("What would you like to do with " + item.getName() + "?");
                    System.out.println(" (0) Inspect");
                    System.out.println(" (1) Use");
                    System.out.println(" (2) Drop");
                    System.out.println(" (3) Quit interaction");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 0:
                            item.inspect();
                            break;
                        case 1:
                            item.interact(player);

                            keepItemInteracting = false;
                            break;
                        case 2:
                            System.out.println("Are you sure you want to drop the " + item.getName() + "?");
                            System.out.println(" (0) Yes");
                            System.out.println(" (1) No");
                            System.out.println(" (2) Quit interaction");
                            choice = scanner.nextInt();
                            if (choice == 0) {
                                item.drop(player);
                                System.out.println("You dropped the " + item.getName() + " on the ground.");
                                keepItemInteracting = false;
                            }
                            break;
                        case 3:
                            keepItemInteracting = false;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            } else {
                System.out.println("There is no item at this location.");
            }

        }

    }
}
