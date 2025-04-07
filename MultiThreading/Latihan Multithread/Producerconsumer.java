public class SharedData {
    int data;
    boolean valueSet = false;
    synchronized void set(int value) {
    if (valueSet) { //baru saja membangkitkan sebuah nilai
        try {
            wait();
        } catch (InterruptedException ie) {
        }
    }
        System.out.println("Generate " + value);
        data = value;
        valueSet = true;
        notify();
        }
        synchronized int get() {
        if (!valueSet) { //produsen belum men-set sebuah nilai
            try {
                wait();
        } catch (InterruptedException ie) {
        }
    }
    System.out.println("Get " + data);
    valueSet = false;
    notify();
    return data;
    }
}

public class Produser implements Runnable {
    SharedData sd;
    Produser(SharedData sd) {
    this.sd = sd;
    new Thread(this, "Produser").start();
    }
    public void run() {
    for (int i = 0; i < 10; i++) {
        sd.set((int)(Math.random()*100));
        }
    }
}

public class Konsumer implements Runnable{
    SharedData sd;
    Konsumer(SharedData sd) {
    this.sd = sd;
        new Thread(this, "Consumer").start();
        }
    public void run() {
    for (int i = 0; i < 10 ; i++) {
        sd.get();
        }
    }
}


public class Producerconsumer {
    public static void main(String[] args) {
        SharedData sd = new SharedData();
        new Produser(sd);
        new Konsumer(sd);
    }
}
