package nl.rug.oop.rpg;

/**
 * The player class.
 */
public class Player {
    /**
     * The name of the player.
     */
    private String name;
    /**
     * The current room of the player.
     */
    private Room currentRoom;
    /**
     * The health of the player.
     */
    private int health;
    /**
     * The damage the player does.
     */
    private int damage;

    /**
     * Constructor Player.
     *
     * @param name        the name of the player
     * @param currentRoom the current room of the player
     */
    public Player(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
        this.health = 100;
        this.damage = 10;
    }

    /**
     * Reduce the player's health by the given damage amount.
     *
     * @param damage the damage taken
     */
    public void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Get the player name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the current room.
     *
     * @return currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Set the current room.
     *
     * @param currentRoom the current room
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
