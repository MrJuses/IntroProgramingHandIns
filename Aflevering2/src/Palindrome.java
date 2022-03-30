import java.util.*;

public class Palindrome {
    public static void main(String[] args){
        //opret variabler og scanner samt input
        boolean compare = false;
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a word or sentence to see if the word/sentence is a palindrome:");

        //vi sikrer os at der findes 2 versioner: den originale og en hvor der ingen specialtegn eller store bogstaver er så der ikke er nogen chance for at det ikke matcher
        String input = console.nextLine();
        String palind = input.toLowerCase().replaceAll("[^a-zA-Z]+","");

        //vi sammenligner bogstav for bogstav hvor den ene side er omvendt
        for(int i = 0 ; i < palind.length() ; i++){
            compare = palind.charAt(i) == palind.charAt(palind.length()-i-1);
        }
        if(compare){
            System.out.println("'" + input + "'\nIs a palindrome!");
        } else {
            System.out.println("'" + input + "'\nIs NOT a palindrome!");
        }
    }
}
