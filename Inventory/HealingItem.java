package nl.rug.oop.rpg.Inventory;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.player.Player;

@Getter
@Setter
public class HealingItem extends Item{
    public HealingItem(String name, String description, String effect) {
        super(name, description, effect);
    }

    @Override
    public void interact(Player player) {
        int val = player.heal();
        System.out.println("Congratulations, you poured the healing potion over your wounds and recovered" + val + "HP.");
    }

}
