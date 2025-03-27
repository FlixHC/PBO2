import java.util.*;

public class Koleksi5 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Jennie");
        list.add("Sherly");
        list.add("Nopeliba");
        list.add("Oktria");
        list.add("Angelyne");
        list.add("Michella");
        System.out.println(list);
        
        System.out.println("2 : "+list.get(2));
        System.out.println("0 : "+list.get(0));
        
        LinkedList queue = new LinkedList();
        queue.addFirst("Oktria");
        queue.addFirst("Sherly");
        queue.addFirst("Jennie");
        queue.addFirst("Nopeliba");
        queue.addFirst("Michella");
        queue.addFirst("Angelyne");
        
        queue.removeLast();
        queue.removeLast();
        
        System.out.println();
        
    }
}
