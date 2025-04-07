public class PrintNameThread implements Runnable {
    Thread thread;
    PrintNameThread (String name){
        thread = new Thread (this, name);
        thread.start();
    }
    @Override
    public void run(){
        String name = thread.getName();
        for (int i = 0 ; i < 10; i++){
            System.out.print(name);
        }
    }
}

public class Runnable1 {

    public static void main(String[] args) {
        new PrintNameThread ("A");
        new PrintNameThread ("a");
        new PrintNameThread ("B");
        new PrintNameThread ("b");
    }
}
