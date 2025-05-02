package nl.rug.oop.rpg.Inventory;
import lombok.Getter;
import lombok.Setter;
import nl.rug.oop.rpg.player.Player;

 @Getter
 @Setter
public class AttackItem extends Item{

    public AttackItem(String name, String description, String effect) {
        super(name, description, effect);
    }

     @Override
    public void interact(Player player) {
        player.setDamage(player.getDamage() * 2);
        System.out.println("Your damage has been doubled! Kinda scary for your enemies...");
    }
}
