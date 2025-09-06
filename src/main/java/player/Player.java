package nl.rug.oop.rpg.player;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.interfaces.Attackable;
import nl.rug.oop.rpg.asset.Room;

/**
 * The player class.
 */
@Getter
@Setter
public class Player implements Attackable {
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
     * The maximum health of the player.
     */
    private int maxHealth;
    /**
     * The base damage the player does.
     */
    private int damage;
    /**
     * The damage multiplier to the player's damage.
     */
    private int damageMultiplier;
    /**
     * The damage added to the player's damage.
     */
    private int damageAdditive;
    /**
     * The damage subtracted from the attacks of the enemies.
     */
    private int damageResistance;
    /**
     * The damage resistance multiplier to the player's damage resistance.
     */
    private int damageResistanceMultiplier;
    /**
     * The inventory of the player.
     */
    private Inventory inventory;

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
        this.maxHealth = 100;
        this.damage = 10;
        this.damageResistance = 0;
        this.inventory = new Inventory();
    }

    /**
     * Increase the damage.
     *
     * @param increase the amount that damage gets increased
     */
    public void increaseDamage(int increase) {
        this.damage = damage + increase;
    }

    /**
     * Increases the damage negated by the armor of the player.
     *
     * @param increase the amount that damage resistance gets increased
     */
    public void increaseDamageResistance(int increase) {
        this.damageResistance = damageResistance + increase;
    }

    /**
     * Reduce the player's health by the given damage amount.
     *
     * @param damage the damage taken
     * @return true if the player is still alive, false otherwise
     */
    public boolean reduceHealth(int damage) {
        health = health - damage;
        return health > 0;
    }

    /**
     * Reduce the player's health by the given damage amount.
     * Taking into account the damage resistance of the player.
     *
     * @param damage the damage taken, taking into account the damage resistance of the player.
     * @return true if the player is still alive, false otherwise
     */
    public boolean reduceCombatHealth(int damage) {
        health = health - (damage - damageResistance * damageResistanceMultiplier);
        return health > 0;
    }

    /**
     * Increase the player's health till it reaches the maximum health.
     *
     * @param increase the amount that health gets increased
     */
    public void increaseHealth(int increase) {
        this.health = Math.max(health + increase, maxHealth);
    }

    /**
     * Check if the player is alive.
     *
     * @return true if the player is alive, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * The player attacks the given target.
     *
     * @param target the target
     * @return true if the target is still alive, false otherwise
     */
    public boolean attack(Attackable target) {
        int damage = (this.damage + this.damageAdditive) * this.damageMultiplier;
        boolean targetSurvived = target.reduceCombatHealth(damage);
        if (!targetSurvived) {
            this.currentRoom.removeDeadNPCs();
            return false;
        }
        System.out.println(this.name + " attacked the target with " + damage + " damage!");
        return true;

    }

    /**
     * Handle the player's death.
     */
    public void onDeath() {
        gameOver();
    }

    /**
     * Print a game over message and exit the game.
     */
    public void gameOver() {
        System.out.println("Game over!");
        System.out.println("You lost!");
        System.out.println("The game will now exit.");
        System.exit(0);
    }
}

