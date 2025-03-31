public class counter {
    private Long value = 0L;
    
    public synchronized void increment(){ //Menggunakan Synchronized untuk mencegah race condition
        value++;
    }
    
    public synchronized Long getValue(){
        return value;
    }
}
