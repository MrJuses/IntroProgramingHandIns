package Opgave3;

import lib.StdDraw;
import java.util.*;

public class GameOfLife {
    public int[][] grid;
    public int[][] futuregrid;
    int alive;
    Random rand = new Random();

    public static void main(String[] args){
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameoflife(3);
        while(true){
            gameOfLife.init(3);
            gameOfLife.state(3);
        }


    }
    public void gameoflife(int n){
        StdDraw.setCanvasSize();
        StdDraw.setXscale(-1,n);
        StdDraw.setYscale(-1,n);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.2);
        grid =  new int [n][n];
        for(int x = 0 ; x < n ; x++){
            for(int y = 0 ; y < n ; y++){
                grid[x][y] = rand.nextInt(0,2);
                System.out.println(grid[x][y]);
            }
        }
        init(n);
    }
    public void init(int n){
        for(int x = 0 ; x < n ; x++){
            for(int y = 0 ; y < n ; y++){
                if(grid[x][y] == 1){
                    StdDraw.point(x,y);
                    StdDraw.show();
                }
            }
        }
    }
    public void state(int n){
        //lonely
        for(int x = 0 ; x < n ; x++){
            for(int y = 0 ; y < n ; y++){
                //Corners:
                if(x == 0 && y == 0){
                    update(pass(neighborcheck(x,1,y,1),x,y),x,y);

                } else if(x == 0 && y == n-1){
                    update(pass(neighborcheck(x,1,n-2,n-1),x,y),x,y);

                } else if(x == n-1 && y == 0){
                    update(pass(neighborcheck(n-2,n-1,y,1),x,y),x,y);

                } else if(x == n-1 && y == n-1){
                    update(pass(neighborcheck(n-2,n-1,n-2,n-1),x,y),x,y);

                }
                //Edges
                else if(x == 0){
                    update(pass(neighborcheck(0,1,1,1),x,y),x,y);
                } else if(y == 0){
                    update(pass(neighborcheck(0,1,0,1),x,y),x,y);
                } else if(x == n-1){
                    update(pass(neighborcheck(0,1,0,1),x,y),x,y);
                } else if(y == n-1){
                    update(pass(neighborcheck(0,1,0,1),x,y),x,y);
                }
                //Middle
                else{
                    update(pass(neighborcheck(0,1,0,1),x,y),x,y);
                }
            }
        }

        System.out.println(grid);
        grid = futuregrid;
        System.out.println(grid);
    }
    public int neighborcheck(int xs, int xe, int ys, int ye){
        for(int x = xs ; x < xe ; x++){
            for(int y = ys ; y < ye ; y++){
                this.alive += grid[x][y];
            }
        }
        return this.alive;
    }
    public Boolean pass(int neighborcheck, int x, int y) {
        int neighbors = neighborcheck-grid[x][y];
        if(grid[x][y] == 1 && neighbors < 2){
            return false;
        } else if(grid[x][y] == 1 && neighbors > 3){
            return false;
        } else if(grid[x][y] == 1 && neighbors == 2 || neighbors == 3){
            return true;
        } else {
            return true;
        }
    }
    public void update(boolean status, int x, int y){
        if(status){
            futuregrid[x][y] = 1;
        } else{
            futuregrid[x][y] = 0;
        }
    }
}
