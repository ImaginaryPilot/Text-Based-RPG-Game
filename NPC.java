package nl.rug.oop.rpg;

/**
 * The NPC class.
 */
public class NPC implements Inspectable, Interactable {
    /**
     * The description of the NPC.
     */
    private String description;

    /**
     * Constructor NPC.
     *
     * @param description the description of the NPC
     */
    public NPC(String description) {
        this.description = description;
    }

    /**
     * Inspect the NPC.
     */
    @Override
    public void inspect() {

    }

    /**
     * Interact with the NPC.
     *
     * @param player the player
     */
    @Override
    public void interact(Player player) {
        System.out.println("Howdy, " + player.getName() + "!");
    }

    /**
     * Get the NPC description.
     *
     * @return description
     */
    public String getNPCDescription() {
        return description;
    }
}
