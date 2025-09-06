package nl.rug.oop.rpg.Inventory;

import nl.rug.oop.rpg.player.Player;

/**
 * DefenseMultiplicativeItem class.
 * <p>
 * Defense items that increase the damage resistance of the player by adding a certain amount of damage resistance.
 */
public class DefenseMultiplicativeItem extends DefenseItem {
    /**
     * The default use message.
     */
    private static final String DEFAULT_USEMESSAGE = "Your damage resistance has been multiplied by %.2f!!";

    /**
     * The damage resistance.
     */
    private final double damageResistance;

    /**
     * Constructor DefenseMultiplicativeItem.
     * @param name The name of the item.
     * @param description The description of the item.
     * @param effect The effect of the item.
     * @param useMessage The message that gets displayed when the item gets used.
     * @param damageResistance The amount of damage resistance that gets multiplied to the player's damage resistance.
     */
    public DefenseMultiplicativeItem(
            String name,
            String description,
            String effect,
            String useMessage,
            double damageResistance) {
        super(name, description, effect, useMessage);
        this.damageResistance = damageResistance;
    }

    /**
     * Constructor DefenseMultiplicativeItem with a default use message.
     * @param name The name of the item.
     * @param description The description of the item.
     * @param effect The effect of the item.
     * @param damageResistance The amount of damage resistance that gets multiplied to the player's damage resistance.'
     */
    public DefenseMultiplicativeItem(String name, String description, String effect, double damageResistance) {
        this(name, description, effect, String.format(DEFAULT_USEMESSAGE, damageResistance), damageResistance);
    }

    /**
     * Interact, multiply the damage resistance of the player by the amount of damage resistance.
     * @param player the player who interacts
     */
    @Override
    public void interact(Player player) {
        int newDamageResistance = (int) (player.getDamageResistance() * damageResistance);
        player.setDamageResistance(newDamageResistance);
        this.dropFromInventory(player);
    }
}
