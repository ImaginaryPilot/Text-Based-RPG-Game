package nl.rug.oop.rpg.npc;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.interfaces.Attackable;
import nl.rug.oop.rpg.interfaces.Inspectable;
import nl.rug.oop.rpg.interfaces.Interactable;
import nl.rug.oop.rpg.player.Player;

/**
 * The NPC class.
 */
@Getter
@Setter
public class NPC implements Inspectable, Interactable {
    /**
     * The description of the NPC.
     */
    private final String description;
    /**
     * The health of the NPC.
     */
    private int health;
    /**
     * The maximum health of the NPC.
     */
    private int maxHealth;
    /**
     * The damage the NPC does.
     */
    private int damage;

    /**
     * Constructor NPC.
     *
     * @param description the description of the NPC
     * @param health      the health of the NPC
     * @param damage      the damage the NPC does
     */
    public NPC(String description, int health, int damage) {
        this.description = description;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
    }

    /**
     * Constructor NPC with default values.
     * @param description the description of the NPC
     */
    public NPC(String description) {
        this(description, 100, 10);
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
     * Change the damage amount of the player.
     *
     * @param damage change the damage amount
     */
    public void changeDamage(int damage) {
        this.damage = damage;
    }

    /**
     * NPC attacks the given target (Player).
     *
     * @param target the target (Player)
     */
    public void attack(Attackable target) {
        boolean targetSurvived = target.reduceCombatHealth(damage);
        System.out.println("An enemy attacked you with " + damage + " damage! Health left:" + target.getHealth());
        if (!targetSurvived) {
            target.onDeath();
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
