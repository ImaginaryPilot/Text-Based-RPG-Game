package nl.rug.oop.rpg;

public class Door implements Inspectable, Interactable{
    private Room nextRoom;
    private String description;

    public Door(Room nextRoom, String description){
        this.nextRoom = nextRoom;
        this.description = description;
    }

    @Override
    public void inspect() {
        System.out.println(description);
    }

    @Override
    public void interact(Game game, Player player) {
        game.setCurrentRoom(nextRoom);
    }

    public String getDoorDescription(){
        return description;
    }
}
