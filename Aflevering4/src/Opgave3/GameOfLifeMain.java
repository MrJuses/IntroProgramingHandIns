package Opgave3;

public class GameOfLifeMain {
    public static void main(String[] args) {
        int x = 3;
        int y = 3;
        GameOfLife game = new GameOfLife(x,y);
        while (true) {
            game.init(x,y);
            game.state(x,y);
        }
    }
}
