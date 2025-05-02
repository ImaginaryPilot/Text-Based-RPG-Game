package nl.rug.oop.rpg.inventory;

import lombok.Getter;
import lombok.Setter;

/**
 * DefenseItem class.
 */
@Getter
@Setter
public abstract class DefenseItem extends Item {
    /**
     * The message that gets displayed when the item gets used.
     */
    private String useMessage;

    /**
     * Constructor DefenseItem.
     *
     * @param name        the name
     * @param description the description
     * @param useMessage  the use message
     * @param effect      the effect
     */
    public DefenseItem(String name, String description, String useMessage, String effect) {
        super(name, description, effect);
        this.useMessage = useMessage;
    }

}
