import java.util.*;

public class RomanNumerals {
    public static void main(String[] args){

        //vi opretter scanner og diverse vigtige variabler
        //Bemærk at der er lavet en Stringbuilder som, forskelligt fra en normal string, tillader os at tilføje ord og bogstaver
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a whole number: ");
        int input = console.nextInt();
        int compare = input;
        StringBuilder roman = new StringBuilder("");

        //Checker at indtastet værdi er over 0
        if(input < 0 ){
            System.out.println("You are required to enter a positive number!");
            System.out.println("Enter a whole number: ");
            input = console.nextInt();
            compare = input;
        } if(input == 0){
            roman.append("Nulla");
        }

        //kører alle romertal gennem startende med størst
        while(input != 0){
            while(input >= 1000) {
                roman.append("M");
                input -= 1000;
            } while(input >= 900) {
                roman.append("CM");
                input -= 900;
            } while(input >= 500) {
                roman.append("D");
                input -= 500;
            } while(input >= 400) {
                roman.append("CD");
                input -= 400;
            } while(input >= 100) {
                roman.append("C");
                input -= 100;
            } while(input >= 90) {
                roman.append("XC");
                input -= 90;
            } while(input >= 50) {
                roman.append("L");
                input -= 50;
            } while(input >= 40) {
                roman.append("XL");
                input -= 40;
            } while(input >= 10) {
                roman.append("X");
                input -= 10;
            } while(input >= 9) {
                roman.append("IX");
                input -= 9;
            } while(input >= 5) {
                roman.append("V");
                input -= 5;
            } while(input >= 4) {
                roman.append("IV");
                input -= 4;
            } while(input >= 1) {
                roman.append("I");
                input -= 1;
            }
        }
        System.out.println(compare + " In Roman numerals becomes:\n" + roman);

    }
}
