package Opgave1;

import java.util.*;

public class ArtikelTest {
    public static void main(String[] args){
        Forlag forlag = new Forlag();
        Tidsskrift tidsskrift = new Tidsskrift();
        Artikel artikel = new Artikel();

        forlag.add("University Press","Denmark");

        Tidsskrift.newTidsskrift("Journal of Logic");
        Tidsskrift.newTidsskrift("Journal of Brain");
        Tidsskrift.setForlag(0,"University Press");
        Tidsskrift.setIssn(0,"Unknown");
        Tidsskrift.setForlag(1,"University Press");
        Tidsskrift.setIssn(1,"Unknown");

        Artikel.CreateArticle("A. Abe & A. Turing","A","Journal of Logic");
        Artikel.CreateArticle("B. Bim","B","Journal of Logic");
        int[] B = {1};


        System.out.println(Arrays.toString(Forlag.listforlag.get(0)));
        System.out.println(Arrays.toString(Tidsskrift.listtidsskrift.get(0)));
        System.out.println(Arrays.toString(Tidsskrift.listtidsskrift.get(1)));
        System.out.println(Arrays.toString(Artikel.listarticle.get(0)));
        System.out.println(Arrays.toString(Artikel.listarticle.get(1)));
        forlag.showList();
        artikel.setRefList(0,B);
        Artikel.printRefList(0);

    }
}
