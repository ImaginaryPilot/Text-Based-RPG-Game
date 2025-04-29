package nl.rug.oop.rpg;

public class NPC implements Inspectable, Interactable {
    private String description;

    public NPC(String description) {
        this.description = description;
    }

    @Override
    public void inspect() {

    }

    @Override
    public void interact(Player player) {
        System.out.println("Howdy, " + player.getName() + "!");
    }

    public String getNPCDescription() {
        return description;
    }
}
