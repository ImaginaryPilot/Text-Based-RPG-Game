package nl.rug.oop.rpg.player;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.interfaces.Attackable;
import nl.rug.oop.rpg.asset.Room;

import java.util.Random;

@Getter
@Setter
/**
 * The player class.
 */
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
     * The damage the player does.
     */
    private int damage;
    /**
     * The damage subtracted from the attacks of the enemies.
     */
    private int damageResistance;

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
    }

    /**
     * Change the damage amount of the player.
     *
     * @param damage change the amount of damage taken
     */
    public void changeDamage(int damage){
        this.damage = damage;
    }

    /**
     * Increases the damage negated by the armor of the player.
     *
     */
    public void changeDamageResistance(){
        this.damageResistance = damageResistance + 2;
    }

    /**
     * Reduce the player's health by the given damage amount.
     *
     * @param damage the damage taken
     * @return true if the player is still alive, false otherwise
     */
    public boolean takeDamage(int damage) {
        health = health - (damage - damageResistance);
        return health > 0;
    }

    public int heal(){
        Random rand = new Random();
        int val = rand.nextInt(5) * 10;
        if(health + val > maxHealth){
            int val2 = health;
            this.health = maxHealth;
            return maxHealth - val2;
        }
        else{
            health = health + val;
            return val;
        }

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
        boolean targetSurvived = target.takeDamage(damage);
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

