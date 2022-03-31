package Opgave2;
import lib.StdDraw;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mandelbrot {
    public static void main(String[] args)throws FileNotFoundException {
        mandelbrotLoad(-0.5, -0.5, 0.5, 512, 255);
    }



    public static int iterate(Complex z0, int MAX) {
        Complex z = new Complex(z0);
        for (int i = 0; i < MAX; i++) {
            if (z.abs() > 2.0) {
                return i;
            }
            z = z.times(z).plus(z0);
        }
        return MAX;
    }



    public static void mandelbrot(double x, double y, double s, double g, int MAX) {
        double a = x - s / 2.0;
        double b = x - s / 2.0 + (s * g) / (g - 1.0);
        double c = y - s / 2.0;
        double d = y - s / 2.0 + (s * g) / (g - 1.0);
        StdDraw.show(0);
        StdDraw.setXscale(a, b);
        StdDraw.setYscale(c, d);
        StdDraw.setPenRadius(2.5 / 1000);
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i <= g; i++) {
            for (int j = 0; j <= g; j++) {
                double e = x - s / 2.0 + ((s * i) / (g - 1.0));
                double f = y - s / 2.0 + ((s * j) / (g - 1.0));
                Complex n = new Complex(e, f);
                if (iterate(n, MAX) == MAX) {
                    StdDraw.filledCircle(e, f, 0.001);
                }
            }
        }
        StdDraw.show(0);
    }



    public static void mandelbrotColor(double x, double y, double s, double g, int MAX) {
        double a = x - s / 2.0;
        double b = x - s / 2.0 + (s * g) / (g - 1.0);
        double c = y - s / 2.0;
        double d = y - s / 2.0 + (s * g) / (g - 1.0);
        StdDraw.setXscale(a, b);
        StdDraw.setYscale(c, d);
        StdDraw.setPenRadius(2.5 / 1000);

        Color[] colors = new Color[256];
        for (int i = 0; i <= 255; i++) {
            colors[i] = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        }

        StdDraw.show(0);
        for (int i = 0; i <= g; i++) {
            if (i == (int) (g * 0.25)) {
                System.out.println("25%");
            }
            if (i == (int) (g * 0.5)) {
                System.out.println("50%");
            }
            if (i == (int) (g * 0.75)) {
                System.out.println("75%");
            }
            if (i == g) {
                System.out.println("100%");
            }
            for (int j = 0; j <= g; j++) {
                double e = x - s / 2.0 + ((s * i) / (g - 1.0));
                double f = y - s / 2.0 + ((s * j) / (g - 1.0));
                Complex n = new Complex(e, f);
                for (int k = 0; k <= 255; k++) {
                    if (iterate(n, MAX) == k) {
                        StdDraw.setPenColor(colors[k]);
                        StdDraw.filledCircle(e, f, 0.001);
                    }
                }
            }
        }
        StdDraw.show(0);
    }



    public static void mandelbrotLoad(double x, double y, double s, double g, int MAX) throws FileNotFoundException{
        double a = x - s / 2.0;
        double b = x - s / 2.0 + (s * g) / (g - 1.0);
        double c = y - s / 2.0;
        double d = y - s / 2.0 + (s * g) / (g - 1.0);
        StdDraw.setXscale(a, b);
        StdDraw.setYscale(c, d);
        StdDraw.setPenRadius(2.5 / 1000);

        Scanner file = new Scanner(System.in);
        System.out.println("Hvilken farveprofil ønsker du?");
        Scanner input = new Scanner(new File("Aflevering4/src/lib/" + file.nextLine()));
        Color[] colors = new Color[256];
        for (int i = 0; i <= 255; i++) {
            colors[i] = new Color(input.nextInt(), input.nextInt(), input.nextInt());
        }

        StdDraw.show(0);
        for (int i = 0; i <= g; i++) {
            if (i == (int) (g * 0.25)) {
                System.out.println("25%");
            }
            if (i == (int) (g * 0.5)) {
                System.out.println("50%");
            }
            if (i == (int) (g * 0.75)) {
                System.out.println("75%");
            }
            if (i == g) {
                System.out.println("Done!");
            }
            for (int j = 0; j <= g; j++) {
                double e = x - s / 2.0 + ((s * i) / (g - 1.0));
                double f = y - s / 2.0 + ((s * j) / (g - 1.0));
                Complex n = new Complex(e, f);
                for (int k = 0; k <= 255; k++) {
                    if (iterate(n, MAX) == k) {
                        StdDraw.setPenColor(colors[k]);
                        StdDraw.filledCircle(e, f, 0.001);
                    }
                }
            }
        }
        StdDraw.show(0);
    }
}
