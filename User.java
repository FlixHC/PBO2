/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.world;

/**
 *
 * @author User
 */

//
public class User {

 //Eager Singleton (Instance objek akan dibuat saat proses loading class)


 /*
 public class User {
   private static final User INSTANCE = new User();

    private User(){}

    public static User getInstance(){
       return INSTANCE;
    }

    public String getUserNameById(int id){
       return "isi data cvx";
    }

    public User getUserById(int id){
       return new User();
    }
 }
 */

 //Lazy Singleton (Instansi objek akan dibuatkan ketika belum ada instansi, jika sudah ada maka akan memanggil yang sebelumnya)

 /*
 public class User {
   private static User user;

   private User(){}

   public static User getInstance(){
       if(user == null){
           user = new User();
       }
       return user;
   }

   public String getUserNameById(int id){
       return "isi data abc";
   }

   public User getUserById(int id){
       return new User();
   }
}
*/

 
//Thread Safe Singleton (Menggunakan volatile, instance sebagai penampung, dan synchronized untuk menjamin instansi berupa thread-safe
// dan menjamin pembuatan objek terjadi hanya sekali untuk semua thread

/*
 public class User {
  private static volatile User user;

   private User(){}

   public static User getInstance(){
       if(user == null){
           synchronized(User.class){
               if(user == null){
                   user = new User();
               }
           }
       }
       return user;
   }

   public String getUserNameById(int id){
       return "Isi data dfjk";
   }

   public User getUserById(int id){
       return new User();
   }
 }
*/

 
 //Bill Pugh Singleton (Menggunakan inner static class untuk menampung objek)

 
 /*
 public class User {
  static class UserHolder{
       private static final User INSTANCE = new User();
   }

   private User(){}

   public static User getInstance(){
       return UserHolder.INSTANCE;
   }

   public String getUserNameById(int id){
       return "isi data jlk";
   }

   public User getUserById(int id){
       return new User();
   }
}
*/
