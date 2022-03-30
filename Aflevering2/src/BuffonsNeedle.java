import java.util.*;
import java.math.*;

public class BuffonsNeedle {
    public static void main(String[] args){
        //opretter konstanter og et check som godkender nåle
        int l = 2;
        int t = 2;
        int pass = 0;

        //opretter random og scanner
        Random rand = new Random();
        Scanner console = new Scanner(System.in);

        //input
        System.out.println("Enter number of iterations:");
        int iterations = console.nextInt();

        //loop som kaster n antal nåle og genererer random afstande op til 1 og random vinkler optil 2*PI
        for(int i = 1 ; i <= iterations ; i++){
            double dist = rand.nextDouble(1);
            double angle = rand.nextDouble(Math.PI/2);

            //hvis afstand er mindre eller lig halv afstand gnage sin til vinklen pass
            if (dist <= (l/2)*Math.sin(angle)){
                pass++;
            }
        }
        double approx = (double) (2*l*iterations)/(t*pass);
        System.out.println(iterations + " / " + pass/2 + " = " + approx);
    }
}
