package Opgave3;

import lib.StdDraw;
import java.util.*;

public class GameOfLife {
    public int[][] grid;
    int alive;
    Random rand = new Random();

    public static void main(String[] args){
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameoflife(3);
        StdDraw.point(1,1);
        StdDraw.show();

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
                grid[y][x] = rand.nextInt(0,2);
                System.out.println(grid[y][x]);
            }
        }
        init(n);
    }
    public void init(int n){
        for(int x = 0 ; x < n ; x++){
            for(int y = 0 ; y < n ; y++){
                if(grid[y][x] == 1){
                    StdDraw.point(y,x);
                    StdDraw.show();
                }
            }
        }
    }
    public void state(int n){
        //lonely
        int spot = 0;
        for(int x = 0 ; x < n ; x++){
            for(int y = 0 ; y < n ; y++){
                //Corners:
                if(x == 0 && y == 0){

                } else if(x == 0 && y == n-1){

                } else if(x == n-1 && y == 0){

                } else if(x == n-1 && y == n-1){

                }
                //Edges
                else if(x == 0){

                } else if(y == 0){

                } else if(x == n-1){

                } else if(y == n-1){

                }
                //Middle
                else{

                }
            }
        }
    }
    public void neighborcheck(int start, int end){
        for(int x = start ; x < end ; x++){
            for(int y = start ; y < end ; y++){
                this.alive =+ grid[x][y];
            }
        }
    }
}
