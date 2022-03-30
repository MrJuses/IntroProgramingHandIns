import lib.StdDraw;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class RaceTrack {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("What size racetrack do you want: ");

        double n = console.nextInt();
        initdraw(n);
        initcar(n);
        move(n);
    }

    public static void initdraw(double n) {
        StdDraw.setXscale(-n - 1, n + 1);
        StdDraw.setYscale(-n - 1, n + 1);

        //draw outer box
        drawsquare(n, StdDraw.GRAY);

        //draw racetrack
        StdDraw.setPenRadius(2.5 / 1000);
        StdDraw.setPenColor(StdDraw.BLACK);
        double grid = -n;
        for (int i = 0; i < n * 2; i++) {
            StdDraw.line(grid, -n, grid, n);
            StdDraw.line(-n, grid, n, grid);
            grid++;
        }

        //draw goalline
        StdDraw.setPenRadius(7.5 / 1000);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.line(0, (n / 2), 0, n);

        //draw inner box
        drawsquare(n / 2, StdDraw.WHITE);
    }

    public static void drawsquare(double n, Color color) {
        StdDraw.setPenRadius(5.0 / 1000);
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(0, 0, n);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(0, 0, n);
    }

    public static void initcar(double n) {
        StdDraw.setPenRadius(5.0 / 1000);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(0, Math.ceil(3 * n / 4), 0.25);
    }

    public static void move(double n) {
        Scanner console = new Scanner(System.in);
        int x0 = 0;
        double y0 = Math.ceil(3 * n / 4);
        int xv = 0;
        int yv = 0;
        boolean inbound = true;

        while (inbound) {
            System.out.println("Type in new coordinates to move to separated by space: ");
            int x1 = console.nextInt();
            int y1 = console.nextInt();

            if (Math.abs(x1) <= 1 && Math.abs(y1) <= 1) {
                StdDraw.setPenRadius(7.5 / 1000);
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(x0, y0, x0 + x1 + xv, y0 + y1 + yv);

                x0 = x0 + x1 + xv;
                y0 = y0 + y1 + yv;

                StdDraw.setPenRadius(5.0 / 1000);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledCircle(x0, y0, 0.25);

                xv = xv + x1;
                yv = yv + y1;

                if (n <= Math.abs(x0) || n <= Math.abs(y0) || -n/2 <= x0 && x0 <= n/2 && -n/2 <= y0 && y0 <= n/2 ) {
                    inbound = false;
                    System.out.println("Out of bounds! Game over");
                }
            } else {
                System.out.println("Invalid move! Try again");
                System.out.println(" ");
            }
        }
    }
}
