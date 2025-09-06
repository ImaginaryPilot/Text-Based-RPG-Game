package nl.rug.oop.rpg.menu;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.npc.Enemy;
import nl.rug.oop.rpg.player.Player;

/**
 * The bossfight class.
 */
@Getter
@Setter
public class BossFight {
    /**
     * The boss.
     */
    private Enemy boss;

    /**
     * Boss fight.
     * @param player the player
     * @param boss the boss
     */
    public static void bossFight(Player player, Enemy boss) {
        System.out.println("You have arrived at the final room.");
        System.out.println("You see:");
        System.out.println(boss.getDescription());
        System.out.println("What do you want to do?");

        // TODO implement boss fight
    }
}
