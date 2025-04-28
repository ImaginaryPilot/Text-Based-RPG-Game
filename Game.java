package nl.rug.oop.rpg;
import java.util.Scanner;

public class Game {
    private Player player;
    private Room startRoom;
    private Room currentRoom;
    private Room goalRoom;
    private Scanner scanner = new Scanner(System.in);

    public void startGame(){
        System.out.println("Welcome to ___ RPG");
        System.out.println("Please input a player name:");

        String playerName = scanner.nextLine(); // <-- Read player name
        player = new Player(playerName);
        startRoom = new Room("Lobby", "A desolate and empty lobby.");
        currentRoom = startRoom;
        goalRoom = new Room("Goal", "The room to exponential possibility and ends.");
        Door door = new Door(currentRoom, "A door");
        NPC npc = new NPC("A suspiciously happy looking orc");
        startRoom.addNPC(npc);
        startRoom.addDoor(door);
        goalRoom.addDoor(door);
        System.out.println(player.getName());
    }

    public void playGame(){
        boolean running = true;
        while(running){
            printMenu();
            int choice = scanner.nextInt();
            running = handlePlayerChoice(choice);
        }
    }

    public void endGame(){
        System.out.println("Thanks for playing, " + player.getName() + "!");
        scanner.close();
    }

    // Print Main Menu
    public void printMenu(){
        System.out.println("What do you want to do?");
        System.out.println(" (0) Look around");
        System.out.println(" (1) Look for a way out");
        System.out.println(" (2) Look for company");
        System.out.println(" (3) Change difficulty");
        System.out.println(" (4) Check Inventory");
        System.out.println(" (5) Quit game"); // Temporary
    }

    // Handle all possible player choices in the main menu
    public boolean handlePlayerChoice(int choice){
        switch(choice){
            case 0: // Inspect Room
                System.out.print("You see: ");
                currentRoom.inspect();
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

    // Moving to next room
    public void moveThroughRoom(){
        System.out.println("You look around for doors.");
        System.out.println("You see:");
        for (int i = 0; i < currentRoom.getDoors().size(); i++) {
            Door door = currentRoom.getDoors().get(i); // Get the door from the list
            System.out.println(" (" + i + ") " + door.getDoorDescription());
        }
        System.out.println("Which door do you take? (-1 : stay here)");
        int choice = scanner.nextInt();
        if(choice!= -1){
            System.out.println("You go through the door");
            Door door = currentRoom.getDoors().get(choice);
            door.interact(this, player);
        }
    }

    public void checkNPC(){
        System.out.println("You look if there’s someone here.");
        System.out.println("You see:");
        for (int i = 0; i < currentRoom.getNPCS().size(); i++) {
            NPC npc = currentRoom.getNPCS().get(i); // Get the npc from the list
            System.out.println(" (" + i + ") " + npc.getNPCDescription());
        }
        System.out.println("Interact ? (-1 : do nothing)");
        int choice = scanner.nextInt();
        if(choice!= -1){
            NPC npc = currentRoom.getNPCS().get(choice);
            npc.interact(this, player);
        }
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
