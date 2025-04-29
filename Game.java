package nl.rug.oop.rpg;

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
     * The goal room.
     */
    private Room goalRoom;
    /**
     * The scanner.
     */
    private Scanner scanner;

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
        player = new Player(playerName, startRoom);
        goalRoom = new Room("Goal", "The room to exponential possibility and ends.");
        Door door = new Door(goalRoom, "A door (to the goal room).");
        NPC npc = new NPC("A suspiciously happy looking orc");
        startRoom.addNPC(npc);
        startRoom.addDoor(door);
        System.out.println(player.getName());
    }

    /**
     * Play the game.
     */
    public void playGame() {
        boolean running = true;
        while (running) {
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
        System.out.println(" (4) Check Inventory");
        System.out.println(" (5) Quit game"); // Temporary
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
                moveThroughRoom();
                return true;
            case 2:
                checkNPC();
                return true;
            case 5:
                return false;
            default:
                System.out.println("Invalid option. Please try again.");
                return true;
        }
    }

    /**
     * Move through the current room.
     */
    public void moveThroughRoom() {
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

    /**
     * Check if there are NPCs in the current room.
     */
    public void checkNPC() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println("You look if there’s someone here.");
        System.out.println("You see:");
        for (int i = 0; i < currentRoom.getNPCs().size(); i++) {
            NPC npc = currentRoom.getNPCs().get(i); // Get the npc from the list
            System.out.println(" (" + i + ") " + npc.getNPCDescription());
        }
        System.out.println("Interact ? (-1 : do nothing)");
        int choice = scanner.nextInt();
        if (choice != -1) {
            NPC npc = currentRoom.getNPCs().get(choice);
            npc.interact(player);
        }
    }

}
