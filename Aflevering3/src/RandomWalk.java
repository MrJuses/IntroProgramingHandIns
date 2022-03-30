import java.util.*;

import lib.StdDraw;

public class RandomWalk {
    public static void main(String[] args){
        randomWalk();
    }

    public static void randomWalk() {
        Random rand = new Random();
        int[] oldCoords = {0,0};
        int[] newCoords = {0,0};
        int steps = 0;

        Scanner console = new Scanner(System.in);
        System.out.println("Enter size of grid:");
        int n = console.nextInt();

        StdDraw.setXscale(-n, n);
        StdDraw.setYscale(-n, n);
        StdDraw.setPenRadius(5.0/1000);

        while(Math.abs(newCoords[0]) <= n && Math.abs(newCoords[1]) <= n){
            int Direction = rand.nextInt(4);
            if(Direction == 0){
                newCoords[0]++;
            } if(Direction == 1){
                newCoords[1]++;
            } if(Direction == 2){
                newCoords[0]--;
            } if(Direction == 3) {
                newCoords[1]--;
            }

            StdDraw.show(0);
            StdDraw.line(oldCoords[0],oldCoords[1],newCoords[0],newCoords[1]);

            oldCoords[0] = newCoords[0];
            oldCoords[1] = newCoords[1];
            steps++;
            System.out.println("Position = (" + oldCoords[0] + "," + oldCoords[1] + ")");
        }
        System.out.println("\nTotal number of steps = " + steps);
    }
}

