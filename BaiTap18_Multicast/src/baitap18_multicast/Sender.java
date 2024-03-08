/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap18_multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Desktop
 */
public class Sender {
    public static void main(String[] args) {
        System.out.println("Đang gửi dữ liệu!");
        try {
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket();
            
            String message = "Hello from the sender!";
            byte[] sendData = message.getBytes();
            
            while(true){
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, 6789);
                socket.send(sendPacket);
                Thread.sleep(1000);                
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
