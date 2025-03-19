/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.world;

/**
 *
 * @author User
 */
public class World {  
   public static void main(String[] args) {
       User user = User.getInstance();
       System.out.println("user.getUserNameById(1) = "+ user.getUserNameById(1));
       System.out.println("user.getUserById(2) = "+ user.getUserById(1));
       System.out.println(user == User.getInstance());
   }
}
