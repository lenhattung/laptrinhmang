/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap12;

import java.net.Socket;

/**
 *
 * @author Desktop
 */
public class PortScanner {
    public static void main(String[] args) {
        //checkPort("localhost");
        checkPort("www.titv.vn");
    }
    
    public static void checkPort(String urlString){
        int startPort = 1;
        int endPort = 100000;
        
        System.out.println("Đanh quét các port của máy: "+urlString);
        
        for (int i = startPort; i <= endPort; i++) {
            try {
                Socket socket = new Socket(urlString, i);
                System.out.println("Cổng: " + i +" đang mở");
                socket.close();
            } catch (Exception e) {
                //
            }
        }
        System.out.println("Quét cổng hoàn tất.");
    }
}
