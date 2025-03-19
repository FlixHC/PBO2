/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.world;

/**
 *
 * @author User
 */
public class User {
 static class UserHolder{
       private static final User INSTANCE = new User();
   }

   private User(){}

   public static User getInstance(){
       return UserHolder.INSTANCE;
   }

   public String getUserNameById(int id){
       return "jlk";
   }

   public User getUserById(int id){
       return new User();
   }
}
