public class PrintStringThreads implements Runnable{
    Thread thread;
    String str1, str2;
    TwoString ts;
    PrintStringThreads (String str1, String str2, TwoString ts){
        this.str1 = str1;
        this.str2 = str2;
        this.ts = ts;
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run(){
        synchronized (ts){
        ts.print(str1, str2);
        }
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

public class Synced2 {

    public static void main(String[] args) {
        TwoString ts = new TwoString();
        new PrintStringThreads("Hello ", "there.", ts);
        new PrintStringThreads("Good ", "bye.", ts);
        new PrintStringThreads("Say ", "cheese!", ts);
    }
}
