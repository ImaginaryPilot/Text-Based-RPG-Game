package nl.rug.oop.rpg.menu;

import nl.rug.oop.rpg.npc.Enemy;
import nl.rug.oop.rpg.player.Player;


public final class BossFight {
    Enemy boss;
    public static void bossFight(Player player, Enemy boss){
        System.out.println("You have arrived at the final room.");
        System.out.println("You see:");
        System.out.println(boss.getDescription());
        System.out.println("What do you want to do?");

        // TODO implement boss fight
    }
}
