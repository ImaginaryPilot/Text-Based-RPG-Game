package nl.rug.oop.rpg.inventory;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.player.Player;

/**
 * Healing Item.
 */
@Getter
@Setter
public class HealingItem extends Item{

    /**
     * Constructor of Healing Item.
     *
     * @param  name is the name of the item
     * @param description is the description of the item
     * @param effect is the effect of the item
     */
    public HealingItem(String name, String description, String effect) {
        super(name, description, effect);
    }

    @Override
    public void interact(Player player) {
        /*
        int val = player.heal();
        public int heal() {
            Random rand = new Random();
            int val = rand.nextInt(5) * 10;
            if (health + val > maxHealth) {
                int val2 = health;
                this.health = maxHealth;
                return maxHealth - val2;
            } else {
                health = health + val;
                return val;
            }
        }
        System.out.println("Congratulations, you have recovered" + val + "HP.");
        */
    }
}
