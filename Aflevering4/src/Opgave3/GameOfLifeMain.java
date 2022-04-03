package Opgave3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameOfLifeMain {
    public static void main(String[] args) throws FileNotFoundException {
        int xlim = 4;
        int ylim = 4;
        GameOfLife game = new GameOfLife(xlim,ylim);
        while (true) {
            game.init(xlim,ylim);
            game.state(xlim,ylim);
        }
    }
}