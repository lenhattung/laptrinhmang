/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap11;

import java.net.InetAddress;

/**
 *
 * @author Desktop
 */
public class ViduInetAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            // Ví dụ 1
            String domain = "www.google.com";
            InetAddress address = InetAddress.getByName(domain);
            
            System.out.println("Tên miền: "+ domain);
            System.out.println("IP: "+ address.getHostAddress());
            
            
            // Ví dụ 2
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Địa chỉ IP của localhost: " + localhost.getHostAddress());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
}
