import java.util.*;

public class Koleksi3 {

    public static void main(String[] args) {
        String[] words = {"saya", "ingin", "lulus", "saya", "akan", "berusaha"};
        
        //HashSet untuk unik
        Set<String> uniques = new HashSet <String>();
        
        //HashSet untuk duplikat
        Set<String> dups = new HashSet <String>();
        
        //Memisahkan duplikat
        for (String a : words)
            if (!uniques.add(a))
                dups.add(a);
        
      //Destructive set-difference (Pemisahan duplikat dari unik)
      uniques.removeAll(dups);
      System.out.println ("Unique words: " + uniques);
      System.out.println("Duplicate words: " + dups);
    }
}
