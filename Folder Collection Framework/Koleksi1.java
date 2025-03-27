import java.util.*;

public class Koleksi1 {

    public static void main (String[] Args){
        
        //Menambah elemen ke koleksi
        Set set = new HashSet();
        set.add("Sistem");
        set.add("Teknologi Informasi");
        set.add("Bisnis");
        set.add("Digital");
        set.add("Kewirausahaan");
        
        System.out.print("Elemen pada HashSet :");
        System.out.println(set);
        
        Set sortSet = new TreeSet (set);
        System.out.print ("Elemen pada TreeSet :");
        System.out.println (sortSet);
    }
}
