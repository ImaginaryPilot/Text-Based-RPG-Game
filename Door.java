package nl.rug.oop.rpg;

/**
 * The Door class.
 */
public class Door implements Inspectable, Interactable {
    /**
     * The next room the door leads to.
     */
    private Room nextRoom;
    /**
     * The description of the door.
     */
    private String description;

    /**
     * Constructor Door.
     *
     * @param nextRoom    the next room the door leads to
     * @param description the description of the door
     */
    public Door(Room nextRoom, String description) {
        this.nextRoom = nextRoom;
        this.description = description;
    }

    /**
     * Inspect the door.
     */
    @Override
    public void inspect() {
        System.out.println(description);
    }

    /**
     * Interact with the door.
     *
     * @param player the player
     */
    @Override
    public void interact(Player player) {
        player.setCurrentRoom(nextRoom);
    }

    /**
     * Get the door description.
     *
     * @return description
     */
    public String getDoorDescription() {
        return description;
    }
}
