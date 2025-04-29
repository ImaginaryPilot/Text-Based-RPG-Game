package nl.rug.oop.rpg;

/**
 * The NPC class.
 */
public class NPC implements Inspectable, Interactable {
    /**
     * The default health of the NPC.
     */
    private static final int DEFAULT_HEALTH = 100;
    /**
     * The default damage of the NPC.
     */
    private static final int DEFAULT_DAMAGE = 10;
    /**
     * The description of the NPC.
     */
    protected final String description;
    /**
     * The health of the NPC.
     */
    protected int health;
    /**
     * The damage the NPC does.
     */
    protected int damage;

    /**
     * Constructor NPC.
     *
     * @param description the description of the NPC
     */
    public NPC(String description) {
        this.description = description;
        this.health = DEFAULT_HEALTH;
        this.damage = DEFAULT_DAMAGE;
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

    /**
     * Get the NPC health.
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Reduce the NPC's health by the given damage amount.
     *
     * @param damage the damage taken
     * @return true if the NPC is still alive, false otherwise
     */
    public boolean takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            onDeath();
            return false;
        }
        return true;
    }

    /**
     * NPC attacks the given target (Player).
     *
     * @param target the target (Player)
     */
    public void attack(Attackable target) {
        boolean targetSurvived = target.takeDamage(damage);
        System.out.println("An enemy attacked you with " + damage + " damage! Health left:" + target.getHealth());
        if (!targetSurvived) {
            target.onDeath();
            return;
        }
    }

    /**
     * Check if the NPC is alive.
     *
     * @return true if the NPC is alive, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Handle the NPC's death.
     */
    public void onDeath() {
        System.out.println(this.description + "has died. He is dead I think.");
    }
}
