package nl.rug.oop.rpg.asset;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.interfaces.Inspectable;
import nl.rug.oop.rpg.interfaces.Interactable;
import nl.rug.oop.rpg.player.Player;

/**
 * The Door class.
 */
@Getter
@Setter
public class Door implements Inspectable, Interactable {
    /**
     * The next room the door leads to.
     */
    private final Room nextRoom;
    /**
     * The description of the door.
     */
    private final String description;

    /**
     * Constructor Door.
     *
     * @param nextRoom    the room the door leads to
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
}
