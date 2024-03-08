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
public class Receiver {
    public static void main(String[] args) {
        System.out.println("Receiver 1: ");
        try {
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket(6789);
            socket.joinGroup(group);
            
            while(true){
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Receiver 1: " + receivedMessage);
            }
            // socket.leaveGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
