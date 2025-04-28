package nl.rug.oop.rpg;

/**
 * The main class. This is the starting point.
 */
public class Main {
    /**
     * The main function.
     * 
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        game.playGame();
        game.endGame();
    }
}
