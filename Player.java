package nl.rug.oop.rpg;

public class Player {
    private String name;
    private int health = 100;
    private int damage = 10;

    public Player(String name){
        this.name = name;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public String getName() {
        return name;
    }
}
