package nl.rug.oop.rpg.Inventory;

import nl.rug.oop.rpg.player.Player;

/**
 * DefenseAdditiveItem class.
 * <p>
 * Defense items that increase the damage resistance of the player by adding a certain amount of damage resistance.
 */
public class DefenseAdditiveItem extends DefenseItem {
    /**
     * The default use message.
     */
    private static final String DEFAULT_USEMESSAGE = "Your damage resistance has been increased by %d!";

    /**
     * The damage resistance.
     */
    private final int damageResistance;

    /**
     * Constructor DefenseAdditiveItem.
     *
     * @param name             The name of the item.
     * @param description      The description of the item.
     * @param effect           The effect of the item.
     * @param useMessage       The message that gets displayed when the item gets used.
     * @param damageResistance The amount of damage resistance that gets added to the player's damage resistance.'
     */
    public DefenseAdditiveItem(
            String name,
            String description,
            String effect,
            String useMessage,
            int damageResistance) {
        super(name, description, effect, useMessage);
        this.damageResistance = damageResistance;
    }

    /**
     * Constructor DefenseAdditiveItem with a default use message.
     *
     * @param name             The name of the item.
     * @param description      The description of the item.
     * @param effect           The effect of the item.
     * @param damageResistance The amount of damage resistance that gets added to the player's damage resistance.'
     */
    public DefenseAdditiveItem(String name, String description, String effect, int damageResistance) {
        this(name, description, effect, String.format(DEFAULT_USEMESSAGE, damageResistance), damageResistance);
    }

    /**
     * Interact, increases the damage resistance of the player by the amount of damage resistance.
     * @param player the player who interacts
     */
    @Override
    public void interact(Player player) {
        player.increaseDamageResistance(damageResistance);
        this.deleteFromInventory(player);
        System.out.println(getUseMessage());
    }
}
