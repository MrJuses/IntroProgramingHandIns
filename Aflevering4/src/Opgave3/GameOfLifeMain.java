package Opgave3;

public class GameOfLifeMain {
    public static void main(String[] args) {
        int xlim = 1;
        int ylim = 1;
        GameOfLife game = new GameOfLife(xlim,ylim);
        while (true) {
            game.init(xlim,ylim);
            game.state(xlim,ylim);
        }
    }
}
