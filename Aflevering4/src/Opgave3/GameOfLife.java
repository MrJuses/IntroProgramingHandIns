package Opgave3;

import lib.StdDraw;
import java.util.*;

public class GameOfLife {
    public int[][] grid;
    public int[][] futuregrid;
    int alive = 0;
    Random rand = new Random();

    GameOfLife(int xlim, int ylim) {
        StdDraw.setXscale(-1, xlim-(1/2.0));
        StdDraw.setYscale(-ylim+(1/2.0), 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        grid = new int[ylim][xlim];
        futuregrid = new int[ylim][xlim];
        for (int y = 0; y < ylim; y++) {
            for (int x = 0; x < xlim; x++) {
                grid[y][x] = rand.nextInt(2);
                System.out.print(grid[y][x] + " ");
            }
            System.out.println("");
        }
        System.out.println(" ");
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
        StdDraw.show(10000);
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
                //System.out.println(this.alive);
                //System.out.println(" ");
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
        /*if (grid[y][x] == 1 && neighbors < 2) {
            return false;
        } else if (grid[y][x] == 1 && neighbors > 3) {
            return false;
        } else if (grid[y][x] == 1 && (neighbors == 2 || neighbors == 3)) {
            return true;
        } else if (grid[y][x] == 0 && neighbors == 3) {
            return true;
        } else {
            return true;
        }*/
    }

    /*public void update(boolean status, int x, int y) {
        System.out.println(status);
        if (status) {
            futuregrid[y][x] = 1;
        } else {
            futuregrid[y][x] = 0;
        }
    }*/
}
