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

public class ThreadJoin {

    public static void main(String[] args) {
        System.out.println("Sedang Berjalan...");
        PrintNameThread no1 = new PrintNameThread ("A");
        PrintNameThread no2 = new PrintNameThread ("a");
        PrintNameThread no3 = new PrintNameThread ("B");
        PrintNameThread no4 = new PrintNameThread ("b");

        try{
            no1.thread.join();
            no2.thread.join();
            no3.thread.join();
            no4.thread.join();
        }
        catch (InterruptedException e){
        }
        
        System.out.println(" Thread dimatikan");//Final
    }
}
