package Opgave2;

public class Complex {
    // Felter
    private double re, im;

    // getRe
    public double getRe() {
        return re;
    }

    // getIm
    public double getIm() {
        return im;
    }

    // 1. konstruktør
    public Complex() {
        re = 0;
        im = 0;
    }

    // 2. konstruktør
    public Complex(double initRe, double initIm) {
        re = initRe;
        im = initIm;
    }

    // 3. konstruktør
    public Complex(Complex z) {
        re = z.getRe();
        im = z.getIm();
    }

    public double abs() {
        return Math.sqrt(re * re + im * im);
    }

    public Complex plus(Complex other) {
        double newRe = re + other.getRe();
        double newIm = im + other.getIm();
        return new Complex(newRe, newIm);
    }

    public Complex times(Complex other) {
        double newRe = re * other.getRe() - im * other.getIm();
        double newIm = im * other.getRe() + re * other.getIm();
        return new Complex(newRe,newIm);
    }

    public String complexToString() {
        Object newRe = re;
        Object newIm = im;
        return newRe.toString() + " + " + newIm.toString() + "i";
    }
}
