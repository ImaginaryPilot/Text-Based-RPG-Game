package nl.rug.oop.rpg;

import nl.rug.oop.rpg.asset.Door;
import nl.rug.oop.rpg.asset.Room;
import nl.rug.oop.rpg.menu.*;
import nl.rug.oop.rpg.npc.Enemy;
import nl.rug.oop.rpg.npc.NPC;
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
    private Enemy boss;
    /**
     * The goal room.
     */
    private Room goalRoom;
    private Room traderRoom;
    /**
     * The scanner.
     */
    private Scanner scanner;
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
            if(player.getCurrentRoom() == goalRoom) {
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
            case 0: // Inspect Room
                System.out.print("You see: ");
                player.getCurrentRoom().inspect();
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
            case 7:
                return false;
            default:
                System.out.println("Invalid option. Please try again.");
                return true;
        }
    }
}
