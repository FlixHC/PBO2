import java.util.*;

public class Koleksi2 {

    public static void main(String[] args) {
        String[] sentences = {"sistem", "informasi", "dan", "teknologi", "informasi"};
        Set<String> s = new HashSet<String>();
        
        //Pemisahan kata duplikat
        for (String a : sentences)
         if (!s.add(a))
             
        System.out.println("Duplicate detected: " + a);
        System.out.println(s.size() + " distinct words: " + s);
    }     
}
