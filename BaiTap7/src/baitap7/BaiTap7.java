/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap7;

import java.util.Iterator;

/**
 *
 * @author Desktop
 */
public class BaiTap7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main");
        
        Thread th = new TaskA();
        th.start();
        
        Thread th2 = new Thread(new TaskB());              
        th2.start();
    
        System.out.println("Ket thuc Main");
    }
    
}
