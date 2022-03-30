package Opgave1;

import java.util.*;

/**Does: New Article, Reflist between articles*/
public class Artikel {
    public static List<String[]> listarticle = new ArrayList<>();
    public static List<String[]> ref = new ArrayList<>();

    /**Creates Article with forfatter, titel, tidsskrift*/
    public static void CreateArticle(String newforfatter, String newtitel, String newtidsskrift){
        listarticle.add(new String[] {newforfatter, newtitel, newtidsskrift,""});
    }

    /**Creates reference between articles
     * @return reflist*/
    public List<String[]> setRefList(int A, int[] B) {
        this.ref.add(listarticle.get(A));
        for(int i = 0 ; i < B.length ; i++){
            this.ref.add(listarticle.get(B[i]));
        }
        return ref;
    }

    /**print the references for A*/
    public static void printRefList(int A){
        System.out.println(Arrays.toString(ref.get(A)));
        System.out.println("Has reference(s) to: ");
        for(int i = 1 ; i < ref.size() ; i++){
            System.out.println(Arrays.toString(ref.get(i)));
        }
    }
}
