public class PrintStringThreads implements Runnable {
    Thread thread;
    String str1, str2;
    PrintStringThreads (String str1, String str2){
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

public class TwoString {
    synchronized static void print (String str1, String str2){
        System.out.print(str1);
        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e){
        }
        System.out.print(str2);
    }
}

public class Synced1 {

    public static void main(String[] args) {
        new PrintStringThreads("Hello ", "there.");
        new PrintStringThreads("Good ", "bye.");
        new PrintStringThreads("Say ", "cheese!");
    }
}
