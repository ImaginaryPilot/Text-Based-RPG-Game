package nl.rug.oop.rpg.npc;

import nl.rug.oop.rpg.interfaces.Attackable;
import nl.rug.oop.rpg.player.Player;

/**
 * The Enemy class.
 */
public class Enemy extends NPC implements Attackable {
    /**
     * The default health for an NPC.
     */
    private static final int DEFAULT_HEALTH = 100;
    /**
     * The default damage for an NPC.
     */
    private static final int DEFAULT_DAMAGE = 10;

    /**
     * Constructor NPC.
     *
     * @param description the description of the NPC
     * @param health      the health of the NPC
     * @param damage      the damage the NPC does
     */
    public Enemy(String description, int health, int damage) {
        super(description, health, damage);
    }

    /**
     * Constructor NPC with default values.
     *
     * @param description the description of the NPC
     */
    public Enemy(String description) {
        this(description, DEFAULT_HEALTH, DEFAULT_DAMAGE);
    }

    /**
     * Interact with the Enemy NPC.
     *
     * @param player the player
     */
    @Override
    public void interact(Player player) {
        System.out.println("Howdy, " + player.getName() + "! I'm really friendly!");
    }

    /**
     * Reduce the NPC's health by the given damage amount.
     *
     * @param damage the damage taken
     * @return true if the NPC is still alive, false otherwise
     */
    @Override
    public boolean reduceHealth(int damage) {
        return super.takeDamage(damage);
    }

    /**
     * NPC attacks the given target (Player).
     *
     * @param target the target (Player)
     */
    @Override
    public void attack(Attackable target) {
        super.attack(target);
    }

    /**
     * Handle the NPC's death.
     */
    @Override
    public void onDeath() {
        System.out.println(super.getDescription() + "has died. That is one less enemy!");
    }
}
