package Opgave3;

import lib.StdDraw;
import java.util.*;

public class GameOfLife {
    public int[][] grid;
    public int[][] futuregrid;
    int alive = 0;
    Random rand = new Random();

    GameOfLife(int xlim,int ylim){
        StdDraw.setXscale(-1,xlim);
        StdDraw.setYscale(-1,ylim);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(1.1/(double)(xlim+ylim));
        grid =  new int [xlim][ylim];
        futuregrid =  new int [xlim][ylim];
        for(int x = 0 ; x < xlim ; x++){
            for(int y = 0 ; y < ylim ; y++){
                grid[y][x] = rand.nextInt(0,2);
                System.out.println(grid[y][x]);
            }
        }
    }
    public void init(int xlim, int ylim){
        StdDraw.clear();
        for(int x = 0 ; x < xlim ; x++){
            for(int y = 0 ; y < ylim ; y++){
                if(grid[y][x] == 1){
                    StdDraw.point(x,y);
                }
            }
        }
        StdDraw.show(200);
    }
    public void state(int xlim, int ylim){
        //lonely
        for(int x = 0 ; x < xlim ; x++){
            for(int y = 0 ; y < ylim ; y++){
                //Corners:
                if(x == 0 && y == 0){
                    update(pass(neighborcheck(x,1,y,1),x,y),x,y);

                } else if(x == 0 && y == ylim-1){
                    update(pass(neighborcheck(x,1,ylim-2,ylim-1),x,y),x,y);

                } else if(x == xlim-1 && y == 0){
                    update(pass(neighborcheck(xlim-2,xlim-1,y,1),x,y),x,y);

                } else if(x == xlim-1 && y == ylim-1){
                    update(pass(neighborcheck(xlim-2,xlim-1,ylim-2,ylim-1),x,y),x,y);

                }
                //Edges
                else if(x == 0){
                    update(pass(neighborcheck(x,1,y-1,y+1),x,y),x,y);
                } else if(y == 0){
                    update(pass(neighborcheck(x-1,x+1,0,1),x,y),x,y);
                } else if(x == xlim-1){
                    update(pass(neighborcheck(xlim-2,xlim-1,y-1,y+1),x,y),x,y);
                } else if(y == ylim-1){
                    update(pass(neighborcheck(x-1,x+1,ylim-2,ylim-1),x,y),x,y);
                }
                //Middle
                else{
                    update(pass(neighborcheck(x-1,x+1,y-1,y+1),x,y),x,y);
                }
            }
        }
        grid = futuregrid;
    }
    public int neighborcheck(int xs, int xe, int ys, int ye){
        for(int x = xs ; x < xe ; x++){
            for(int y = ys ; y < ye ; y++){
                this.alive += grid[y][x];
            }
        }
        return this.alive;
    }
    public Boolean pass(int neighborcheck, int x, int y) {
        int neighbors = neighborcheck-grid[y][x];
        if(grid[y][x] == 1 && neighbors < 2){
            return false;
        } else if(grid[y][x] == 1 && neighbors > 3){
            return false;
        } else if(grid[y][x] == 1 && neighbors == 2 || neighbors == 3){
            return true;
        } else {
            return true;
        }
    }
    public void update(boolean status, int x, int y){
        if(status){
            futuregrid[y][x] = 1;
        } else{
            futuregrid[y][x] = 0;
        }
    }
}
