/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package streamdemo;

import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class StreamDemo {

    /**
     * @param args the command line arguments
     */
    // Ctrl + F11
    public static void main(String[] args) {
        System.out.println("Stream");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao bien x = ");
        int x = sc.nextInt();
        x = x +1;
        System.out.println("x = " + x);
    }
    
}
