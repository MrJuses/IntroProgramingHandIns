package Opgave1;

import java.util.*;

/**Does: add, show, get*/
public class Forlag {
    public static List<String[]> listforlag = new ArrayList<>();

    /**Prompts for new forlag*/
    public void add(String newName, String newPlace){
        listforlag.add(new String[] {newName, newPlace});
    }
    /**Deletes specific forlag*/
    public void delete(int i){
        listforlag.remove(i);
    }
    /**Prints list of Forlag nummerated from 1st to x*/
    public void showList(){
        for(int i = 0 ; i < listforlag.size() ; i++) {
            System.out.println(i+1 + ":");
            System.out.println("Name: " + listforlag.get(i)[0]);
            System.out.println("Place: " + listforlag.get(i)[1]);
            System.out.println("");
        }
    }
    /**Returns list with specific forlag name and place*/
    public String[] getForlag(int i){
        return listforlag.get(i);
    }
    /**Returns specific name*/
    public String nm(int i){
        return listforlag.get(i)[0];
    }
    /**Returns specific place*/
    public String pc(int i){
        return listforlag.get(i)[1];
    }
}
