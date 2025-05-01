package nl.rug.oop.rpg.Inventory;


import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.player.Player;

@Getter
@Setter
public class DefenseItem extends Item {
    public DefenseItem(String name, String description, String effect) {
        super(name, description, effect);
    }

    @Override
    public void interact(Player player) {
        player.changeDamageResistance();
    }
}
