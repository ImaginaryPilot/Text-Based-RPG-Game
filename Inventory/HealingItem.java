package nl.rug.oop.rpg.Inventory;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.player.Player;

import java.util.Random;

@Getter
@Setter
public class HealingItem extends Item{
    public HealingItem(String name, String description, String effect) {
        super(name, description, effect);
    }

    @Override
    public void interact(Player player) {
//        int val = player.heal();
//        public int heal() {
//            Random rand = new Random();
//            int val = rand.nextInt(5) * 10;
//            if (health + val > maxHealth) {
//                int val2 = health;
//                this.health = maxHealth;
//                return maxHealth - val2;
//            } else {
//                health = health + val;
//                return val;
//            }
//        }
//        System.out.println("Congratulations, you poured the healing potion over your wounds and recovered" + val + "HP.");
    }

}
