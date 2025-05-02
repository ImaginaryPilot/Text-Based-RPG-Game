package nl.rug.oop.rpg;

import nl.rug.oop.rpg.Inventory.Item;
import nl.rug.oop.rpg.asset.Room;
import nl.rug.oop.rpg.menu.*;
import nl.rug.oop.rpg.npc.Enemy;
import nl.rug.oop.rpg.player.Player;
import nl.rug.oop.rpg.generator.LevelGenerator;

import java.util.List;
import java.util.Scanner;

/**
 * The main game class.
 */
public class Game {
    /**
     * The player.
     */
    private Player player;
    /**
     * The Enemy.
     */
    private Enemy boss;
    /**
     * The goal room.
     */
    private Room goalRoom;
    /**
     * The trader's room.
     */
    private Room traderRoom;
    /**
     * The scanner.
     */
    private Scanner scanner;
    /**
     * The level rooms.
     */
    private List<Room> levelRooms;

    /**
     * Constructor Game.
     */
    public Game() {
        this.scanner = new Scanner(System.in);
        this.goalRoom = null;
        this.player = null;
    }

    /**
     * Start the game.
     */
    public void startGame() {
        System.out.println("Welcome to ___ RPG");
        System.out.println("Please input a player name:");

        String playerName = scanner.nextLine(); // <-- Read player name
        Room startRoom = new Room("Lobby", "A desolate and empty lobby.");
        goalRoom = new Room("Vault", "The room to exponential possibility and ends.");
        traderRoom = new Room("Trader's Den", "A hidden nook filled with rare goods.");

        player = new Player(playerName, startRoom);

        // Final Boss
        boss = new Enemy("The red valiant Dragon, protecting it's history.", 200, 20);
        goalRoom.addNPC(boss);

        // Generate intermediate rooms
        levelRooms = LevelGenerator.generateRooms(6, startRoom, goalRoom, traderRoom);

        System.out.println(player.getName() + " enters the lobby...");
    }

    /**
     * Play the game.
     */
    public void playGame() {
        boolean running = true;
        while (running) {
            if (player.getCurrentRoom() == goalRoom) {
                BossFight.bossFight(player, boss);
                running = false;
            }
            printMenu();
            int choice = scanner.nextInt();
            running = handlePlayerChoice(choice);
        }
    }

    /**
     * End the game.
     */
    public void endGame() {
        System.out.println("Thanks for playing, " + player.getName() + "!");
        scanner.close();
    }

    /**
     * Print the menu.
     */
    public void printMenu() {
        System.out.println("What do you want to do?");
        System.out.println(" (0) Look around");
        System.out.println(" (1) Look for a way out");
        System.out.println(" (2) Look for company");
        System.out.println(" (3) Change difficulty");
        System.out.println(" (4) Check Trader");
        System.out.println(" (5) Check Inventory");
        System.out.println(" (6) Check Quests");
        System.out.println(" (7) Quit game"); // Temporary
    }

    /**
     * Handle the player's choice.
     *
     * @param choice the player's choice
     * @return true if the game should continue, false if the game should end
     */
    public boolean handlePlayerChoice(int choice) {
        switch (choice) {
            case 0:
                handleRoom(player);
                return true;
            case 1: // Find all possible doors
                MoveThroughRoom.moveThroughRoom(player, scanner);
                return true;
            case 2:
                CheckNPC.checkNPC(player, scanner);
                return true;
            case 3:
                ChangeDifficulty.changeDifficulty(player, scanner, levelRooms);
                return true;
            case 4:
                MoveToTraderRoom.moveToTraderFrom(player, traderRoom, scanner);
                return true;
            case 5:
                HandleInventory.handleInventory(player, scanner);
                return true;
            case 7:
                return false;
            default:
                System.out.println("Invalid option. Please try again.");
                return true;
        }
    }

    /**
     * Handle the room interaction.
     *
     * @param player the player to interact with the room.
     */
    public void handleRoom(Player player) {
        System.out.print("You see: ");
        player.getCurrentRoom().inspect();
        List<Item> roomItems = player.getCurrentRoom().getItems();
        if (!roomItems.isEmpty()) {
            boolean keepInteracting = true;
            while (keepInteracting) {
                System.out.println("The following items are laying on the ground:");
                for (int i = 0; i < roomItems.size(); i++) {
                    Item item = roomItems.get(i);
                    System.out.println(" (" + i + ") " + item.getName());
                }
                System.out.println("Interact ? (-1 : do nothing)");
                int choice = scanner.nextInt();
                if (choice == -1) {
                    keepInteracting = false;
                } else if (choice < roomItems.size()) {
                    Item item = roomItems.get(choice);
                    handleItem(item, player, scanner);
                } else {
                    System.out.println("There is no item at this location.");
                }
            }
        }
    }

    /**
     * Handle the interaction with an item.
     * @param item the item to interact with.
     * @param player the player to interact with the item.
     * @param scanner the scanner to read user input.
     */
    public static void handleItem(Item item, Player player, Scanner scanner) {
        boolean keepItemInteracting = true;
        while (keepItemInteracting) {
            System.out.println("What would you like to do with " + item.getName() + "?");
            System.out.println(" (0) Inspect");
            System.out.println(" (1) Pick up");
            System.out.println(" (2) Quit interaction");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    item.inspect();
                    break;
                case 1:
                    item.pickup(player);
                    keepItemInteracting = false;
                    break;
                case 2:
                    keepItemInteracting = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
