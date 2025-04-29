package nl.rug.oop.rpg;

public class Player {
    private String name;
    private Room currentRoom;
    private int health;
    private int damage;

    public Player(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
        this.health = 100;
        this.damage = 10;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
