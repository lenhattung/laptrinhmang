/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap16_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Desktop
 */
public class BaiTap16_UDP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9877;
            
            int i = 0;
            while(true){
                String message = "Hello, UDP Server + " +i ;
                byte[] senData = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(senData, senData.length, serverAddress, serverPort);
                socket.send(sendPacket);
              
                i++;
            }
            //socket.close();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    
}
