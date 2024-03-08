/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap16_server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Desktop
 */
public class BaiTap16_UDP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9877);
            
            byte[] receiveData = new byte[1024];
            
            while(true){
                DatagramPacket recivePacket = new DatagramPacket(receiveData, receiveData.length);
                // Nhận một gói tin
                socket.receive(recivePacket);
                                
                String receiveMessage = new String(recivePacket.getData(), 0, recivePacket.getLength());
                
                if(receiveMessage.trim().length()>0)
                    System.out.println("receiveMessage: " + receiveMessage);
            }
            //socket.close();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    
}
