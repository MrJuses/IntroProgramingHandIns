public class UsingClassConstant {
    public static final int LINES = 3;
    public static void main(String[] args) {
        for (int i = 1; i <= LINES ; i++) {
            for (int j = 1; j <= LINES; j++) {
                System.out.print("+-");
            }
            //We move the print function one level in
            // so that it doesn't execute at the end of the program
            // but at the end of each line
            System.out.println("+");
        }
    }
}
