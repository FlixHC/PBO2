public class Contohthread {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () ->{
            try {
                Thread.sleep(2000);
                 System.out.println("Hello from thread " + Thread.currentThread().getName());
            } catch (InterruptedException e){
        }
        };
        
        var thread = new Thread(runnable);
        
        System.out.println("Program sedang berjalan ... ");
        thread.start();
        thread.join();
        System.out.println("Program telah dijalankan");
    }
}
