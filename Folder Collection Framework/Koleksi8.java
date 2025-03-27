import java.util.*;
public class Koleksi8 {

    public static void main(String[] args) {
        
        Vector v = new Vector();
        
        //Add element
        v.add("A");
        v.add("B");
        v.add("C");
        v.add("D");
        v.add("E");
        v.add("F");
        
        System.out.println("Vector contains: " + v);
        
        Enumeration e = v.elements();
        
        ArrayList aList = Collections.list(e);
        System.out.println("ArrayList Contains : "+aList);
    }
}
