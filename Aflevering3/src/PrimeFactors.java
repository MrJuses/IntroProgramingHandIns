import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args){

        // prompter brugeren for et heltals input og gemmer det i en long kaldet InputNumber.
        Scanner console = new Scanner(System.in);
        System.out.print("Enter integer greater than 1 (0 to terminate): ");
        long InputNumber = console.nextLong();

        // Laver en do-løkke der gentager processen medmindre 0 er input.
        do {
            // En løkke der fanger at inputtet er 0 eller negativt.
            if (InputNumber <=0) {
                return;
            }
            // Definerer en liste hvor primtals faktorene kan indgå
            List<Long> list = new ArrayList<Long>();

            // Kører et forloop der tjekker om der eksisterer en rest når man dividerer med et primtal
            // Vi starter ved primtallet 2.
            // Hvis der ikke er nogen rest må 2 gå op i tallet og derfor er det en primtalsfaktor, osv osv osv.
            for (long i = 2; i <= (InputNumber / i); i++) {
                while (InputNumber % i == 0) {
                    list.add(i);
                    InputNumber = InputNumber / i;
                }
            }
            // Tilføjer tallet hvis det er et primtal. Fjerner også outliers hvor Input Number er blevet 1.
            if(InputNumber != 1) {
                list.add(InputNumber);
            }
            // Printer primtalsfaktorene i listen, derefter gentages den indledne kode så InputNumber bliver et nyt tal.
            System.out.print("List of prime factors: " + list + "\n");
            System.out.print("Enter integer greater than 1 (0 to terminate): ");
            InputNumber = console.nextLong();
        } while (InputNumber != 0);
    }
}
