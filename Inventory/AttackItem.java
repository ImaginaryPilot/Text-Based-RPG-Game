package nl.rug.oop.rpg.inventory;

import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.player.Player;

/**
 * Attack Item.
 */
@Getter
@Setter
public class AttackItem extends Item {

    /**
     * Constructor of Attack Item.
     *
     * @param  name is the name of the item
     * @param description is the description of the item
     * @param effect is the effect of the item
     */
    public AttackItem(String name, String description, String effect) {
        super(name, description, effect);
    }

    @Override
    public void interact(Player player) {
        player.setDamage(player.getDamage() * 2);
        System.out.println("Your damage has been doubled! Kinda scary for your enemies...");
    }
}
