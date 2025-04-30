package nl.rug.oop.rpg.menu;

import nl.rug.oop.rpg.asset.Room;
import nl.rug.oop.rpg.npc.NPC;
import nl.rug.oop.rpg.player.Player;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public final class ChangeDifficulty {
    public static void changeDifficulty(Player player, Scanner scanner, List<Room> allRooms){
        Random rand = new Random();
        System.out.println("What difficulty do you wish to change to?");
        System.out.println(" (0) Easy");
        System.out.println(" (1) Medium");
        System.out.println(" (2) Hard");
        System.out.println("Change Difficulty ? (-1 : do nothing)");
        int choice = scanner.nextInt();

        int minDamage = 0, maxDamage = 0;
        switch(choice){
            case -1:
                System.out.println("Difficulty unchanged.");
                return;
            case 0:
                player.changeDamage(12);
                minDamage = 3;
                maxDamage = 6;
                break;
            case 1:
                player.changeDamage(10);
                minDamage = 6;
                maxDamage = 10;
                break;
            case 2:
                player.changeDamage(8);
                minDamage = 10;
                maxDamage = 15;
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }

        for (Room room : allRooms) {
            for (NPC npc : room.getNPCs()) {
                int randomDamage = rand.nextInt(maxDamage - minDamage + 1) + minDamage;
                npc.changeDamage(randomDamage);
            }
        }

        System.out.println("Difficulty change");
    }
}
