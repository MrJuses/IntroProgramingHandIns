package Opgave2;

public class ComplexTest {
    public static void main(String[] args) {
        Complex z1 = new Complex(1, 2); // z1 = 1 + 2i
        Complex z2 = new Complex(4, 5); // z2 = 4 + 5i
        System.out.println(z1.plus(z2).complexToString()); // print z1 + z2
        System.out.println(z1.times(z2).complexToString()); // print z1 * z2
    }
}
