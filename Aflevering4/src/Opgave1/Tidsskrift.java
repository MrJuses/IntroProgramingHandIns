package Opgave1;

import java.util.*;

/**Does: Tidsskrift title/Forlag/ISSN*/
public class Tidsskrift {
    public static List<String[]> listtidsskrift = new ArrayList<>();
    /**Creates new Tidsskrift title*/
    public static void newTidsskrift(String newTitel) {
        listtidsskrift.add(new String[] {newTitel, "", ""});
    }
    /**Pairs Tidsskrift with Forlag*/
    public static void setForlag(int i,String replaceforlag) {
        String[] replacer = listtidsskrift.get(i);
        replacer[1] = replaceforlag;
        listtidsskrift.set(i,replacer);
    }

    /**Sets ISSN*/
    public static void setIssn(int i, String replaceissn) {
        String[] replacer = listtidsskrift.get(i);
        replacer[2] = replaceissn;
        listtidsskrift.set(i,replacer);
    }
}

