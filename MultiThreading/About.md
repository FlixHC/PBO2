# PBO2, Multi Threading

### Multithreading digunakan untuk menjalankan beberapa jalur kode sekaligus untuk mengeksekusi beberapa fungsi secara bersamaan.

### Multithreading dapat diinisiasikan dengan 2 cara yaitu :

## Extends Thread
### Metode ini menggunakan class extension yang mengekstensikan ke Thread yang akan melakukan override pada method run() dan menggunakan start() untuk menjalankan thread secara bersamaan
Dengan adanya thread, kode dapat dijalankan bersamaan dengan beberapa thread yang berjalan pada saat yang sama dan dapat berjalan secara independen 

## Contoh Implementasi
``` java

public class multi extends Thread{
    @Override
    public void run(){
        for (int i = 0; i<5; i++){
            System.out.println(i);
            
            try {
                Thread.sleep(1000); //Sleep memberikan interval x milisecond sebelum menampilkan output kedua
            } catch (InterruptedException ex) {
            }
        }
    }
}

public class Latmulti {

    public static void main(String[] args) {
        for (int i = 1; i<5; i++){
        multi item = new multi();
       
        item.start();
        }
    }
}

```

##Implements Runnable
### Metode ini menggunakan Implements Runnable pada class yang dibuat. Kode kemudian akan dimodifikasi dengan menambahkan Thread baru pada main dan Runnable memiliki kelebihan diatas Extend Thread karena jika sebuah kelas telah menggunakan Extends Thread, maka kelas tersebut tidak dapat melakukan extend kepada kelas lainnya, dimana implement tidak membatasi aksi tersebut dan implement juga dapat dilakukan berkali-kali.

## Contoh Implementasi 
``` java

public class multi implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i<5; i++){
            System.out.println(i);
            
            try {
                Thread.sleep(1000); //Sleep memberikan interval x milisecond sebelum menampilkan output kedua
            } catch (InterruptedException ex) {
            }
        }
    }
}

public class Latmulti {

    public static void main(String[] args) {
        for (int i = 1; i<5; i++){
        multi item = new multi();
        Thread contoh = new Thread(item);
       
        contoh.start();
        }
    }
}

```
