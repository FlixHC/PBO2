public class Nosync {

    public static void main(String[] args) {
        new PritnStringThreads("Hello ", "there.");
        new PritnStringThreads("Good ", "bye.");
        new PritnStringThreads("Say ", "cheese!");
    }
}

public class TwoString {
    static void print (String str1, String str2){
        System.out.print(str1);
        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e){
        }
        System.out.print(str2);
    }
}

public class PritnStringThreads implements Runnable {
    Thread thread;
    String str1, str2;
    PritnStringThreads (String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run(){
        TwoString.print(str1, str2);
    }
}
