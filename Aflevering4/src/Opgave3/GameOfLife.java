package Opgave3;

import lib.StdDraw;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameOfLife {
    public int[][] grid;
    public int[][] futuregrid;
    int alive = 0;
    Random rand = new Random();

    GameOfLife(int xlim, int ylim) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        int cont = 0;
        while (cont == 0) {
            System.out.println("1 for random grid, 2 for specific start from file:");
            if (console.nextInt() == 1) {
                cont = 1;
                break;
            } else if (console.nextInt() == 2) {
                cont = 2;
                break;
            } else {
                System.out.println("You did not type in 1 or 2");
            }
        }
        StdDraw.setXscale(-1, xlim);
        StdDraw.setYscale(-ylim, 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        grid = new int[ylim][xlim];
        futuregrid = new int[ylim][xlim];

        if (cont == 1) {
            for (int y = 0; y < ylim; y++) {
                for (int x = 0; x < xlim; x++) {
                    grid[y][x] = rand.nextInt(2);
                    System.out.print(grid[y][x] + " ");
                }
                System.out.println("");
            }
            System.out.println(" ");
        } else {
            Scanner file = new Scanner(System.in);
            System.out.println("Hvilken startprofil ønsker du?");
            Scanner input = new Scanner(new File("Aflevering4/src/lib/" + file.nextLine()));
            int rows = -1;
            boolean line = true;
            while ((line = input.hasNextLine()) == true) {
                rows++;
            }
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < rows; x++) {
                    grid[y][x] = input.nextInt();
                    System.out.print(grid[y][x] + " ");
                }
                System.out.println("");
            }
            System.out.println(" ");
        }
    }


    public void init(int xlim, int ylim) {
        StdDraw.clear();
        for (int y = 0; y < ylim; y++) {
            for (int x = 0; x < xlim; x++) {
//                if (grid[y][x] == 1) {
//                    StdDraw.filledSquare((x+1-(xlim/(xlim*(4/5.0)))),-(y+1-(ylim/(ylim*(4/5.0)))),1/2.0);
//                } else{
//                    StdDraw.square((x+1-(xlim/(xlim*(4/5.0)))),-(y+1-(ylim/(ylim*(4/5.0)))),1/2.0);
//                }
                if (grid[y][x] == 1) {
                    StdDraw.filledSquare((x),-(y),1/2.0);
                } else{
                    StdDraw.square((x),-(y),1/2.0);
                }
            }
        }
        StdDraw.show(50);
    }

    public void state(int xlim, int ylim) {
        //lonely
        for (int y = 0; y < ylim; y++) {
            for (int x = 0; x < xlim; x++) {
                //Corners:
                if (x == 0 && y == 0) {
                    pass(neighborcheck(x, 1, y, 1), x, y);

                } else if (x == 0 && y == ylim - 1) {
                    pass(neighborcheck(x, 1, ylim - 2, ylim - 1), x, y);

                } else if (x == xlim - 1 && y == 0) {
                    pass(neighborcheck(xlim - 2, xlim - 1, y, 1), x, y);

                } else if (x == xlim - 1 && y == ylim - 1) {
                    pass(neighborcheck(xlim - 2, xlim - 1, ylim - 2, ylim - 1), x, y);
                }
                //Edges
                else if (x == 0) {
                    pass(neighborcheck(x, 1, y - 1, y + 1), x, y);
                } else if (y == 0) {
                    pass(neighborcheck(x - 1, x + 1, y, 1), x, y);
                } else if (x == xlim - 1) {
                    pass(neighborcheck(xlim - 2, xlim-1, y - 1, y + 1), x, y);
                } else if (y == ylim - 1) {
                    pass(neighborcheck(x - 1, x + 1, ylim - 2, ylim - 1), x, y);
                }
                //Middle
                else {
                    pass(neighborcheck(x - 1, x + 1, y - 1, y + 1), x, y);
                }
                System.out.print(futuregrid[y][x] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("");
        grid = futuregrid;
    }

    public int neighborcheck(int xs, int xe, int ys, int ye) {
        this.alive = 0;
        for (int y = ys; y <= ye; y++) {
            for (int x = xs; x <= xe; x++) {
                this.alive += grid[y][x];
            }
        }
        return this.alive;
    }

    public void pass(int neighborcheck, int x, int y) {
        int neighbors = neighborcheck - grid[y][x];
        if(grid[y][x] == 1){
            if(neighbors < 2){
                futuregrid[y][x] = 0;
            } else if(neighbors > 3){
                futuregrid[y][x] = 0;
            } else {
                futuregrid[y][x] = 1;
            }
        } else{
            if(neighbors == 3){
                futuregrid[y][x] = 1;
            }
        }
    }
}
